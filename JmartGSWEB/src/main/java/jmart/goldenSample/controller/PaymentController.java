package jmart.goldenSample.controller;

import jmart.goldenSample.dataset.*;
import jmart.goldenSample.dbjson.*;

import java.nio.file.FileAlreadyExistsException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
class PaymentController implements BasicGetController<Payment>
{
	private final JSONTable<Payment> table;
	
	public PaymentController() throws FileAlreadyExistsException, ClassNotFoundException
	{ table = DBContainer.fetch(Payment.class, "payment.json"); }
	
    @Override
    public JSONTable<Payment> getJSONTable() { return table; }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    boolean create()
    {
        table.list.add(new Payment(0,0,0,new Shipment("a", 0, Shipment.Duration.INSTANT, "b")));
        try { table.write(); }
        catch (Throwable throwable) { throwable.printStackTrace(); }
        return true;
    }
}