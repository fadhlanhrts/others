package jmart.goldenSample.controller;

import jmart.goldenSample.Algorithm;
import jmart.goldenSample.dataset.*;
import jmart.goldenSample.dataset.Invoice.Status;
import jmart.goldenSample.dbjson.*;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
class PaymentController implements BasicGetController<Payment>, InvoiceUpdateListener
{
	private final JSONTable<Payment> table;
	
	public PaymentController() throws FileAlreadyExistsException, ClassNotFoundException
	{ table = DBContainer.fetch(Payment.class, "db/payment.json"); }
	
    @Override
    public JSONTable<Payment> getJSONTable() { return table; }

    @RequestMapping(value="/create", method=RequestMethod.POST)
    boolean create
    (
    		@RequestParam int buyerId,
            @RequestParam int productId,
            @RequestParam int productCount,
            @RequestParam String shipmentAddress,
            @RequestParam byte shipmentDuration
    )
    {
        boolean success = false;
        try
        {
        	final Payment payment = new Payment(buyerId, productId, productCount, new Shipment(shipmentAddress, shipmentDuration, null));
        	final Product product = Algorithm.<Product>find(DBContainer.getTable(Product.class), (e) -> e.id == payment.productId);
        	final Store store     = Algorithm.<Store>find(DBContainer.getTable(Store.class), (e) -> e.id == product.storeId);
			payment.setInvoiceUpdateListener(this);
        	payment.updateRecord(Status.WAITING_CONFIRMATION, String.format("Waiting for Seller: %s's confirmation", store.name));
        	table.add(payment);
        	success = true;
        }
        catch (Throwable throwable) { throwable.printStackTrace(); }
        return success;
    }
    
    @RequestMapping(value="/accept/{id}", method=RequestMethod.POST)
    boolean accept(@PathVariable int id)
    {
        final Payment payment = Algorithm.<Payment>find(table, (e) -> e.id == id);
        if (payment != null && payment.getCurrentRecord().status == Status.WAITING_CONFIRMATION)
        {
            payment.updateRecord(Status.ON_PROGRESS, "");
            return true;
        }
        return false;
    }
    
    @RequestMapping(value="/submit", method=RequestMethod.POST)
    boolean accept
    (
    	@RequestParam int id,
        @RequestParam String receipt
	)
    {
        final Payment payment = Algorithm.<Payment>find(table, (e) -> e.id == id);
        if (payment != null && payment.getCurrentRecord().status == Status.ON_PROGRESS)
        {
        	payment.shipment.receipt = receipt;
            payment.updateRecord(Status.ON_DELIVERY, "");
            return true;
        }
        return false;
    }
    
    @RequestMapping(value="/cancel/{id}", method=RequestMethod.POST)
    boolean cancel(@PathVariable int id)
    {
        final Payment payment = Algorithm.<Payment>find(table, (e) -> e.id == id);
        if (payment != null && payment.getCurrentRecord().status == Status.WAITING_CONFIRMATION)
        {
            payment.updateRecord(Status.CANCELLED, "");
            return true;
        }
        return false;
    }
    
    @Override
	public void onTransactionInit(Invoice invoice)
	{
		final Account account = Algorithm.<Account>find(DBContainer.getTable(Account.class), (e) -> e.id == invoice.buyerId);
		final Product product = Algorithm.<Product>find(DBContainer.getTable(Product.class), (e) -> e.id == invoice.productId);
		account.balance -= product.getAdjustedPrice();
	}
    
    @Override
	public void onTransactionDismissed(Invoice invoice)
	{
		final Product product = Algorithm.<Product>find(DBContainer.getTable(Product.class), (e) -> e.id == invoice.productId);
		final Store store     = Algorithm.<Store>find(DBContainer.getTable(Store.class), (e) -> e.id == product.storeId);
		final Invoice.Status currentStatus = invoice.getCurrentRecord().status;
		if (currentStatus == Status.CANCELLED || currentStatus == Status.FAILED)
		{
			final Account account = Algorithm.<Account>find(DBContainer.getTable(Account.class), (e) -> e.id == invoice.buyerId);
			account.balance += product.getAdjustedPrice();
		}
		else if (currentStatus == Status.FINISHED)
		{
			store.balance += product.price;
		}
	}
}