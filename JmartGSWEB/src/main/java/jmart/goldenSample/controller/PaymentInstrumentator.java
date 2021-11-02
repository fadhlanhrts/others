package jmart.goldenSample.controller;

import jmart.goldenSample.dataset.Invoice.Record;
import jmart.goldenSample.dataset.Invoice.Status;
import jmart.goldenSample.dataset.*;
import jmart.goldenSample.dbjson.*;
import jmart.goldenSample.Algorithm;
import jmart.goldenSample.controller.*;

public class PaymentInstrumentator implements Runnable
{
	public static long WAITING_CONFIRMATION_LIMIT_MS  = 30000;
	public static long ON_PROGRESS_LIMIT_MS           = 30000;
	public static long ON_DELIVERY_AUTO_PROGRESS_MS   = 30000;
	public static long DELIVERED_AUTO_PROGRESS_MS     = 30000;
	
	@Override
	public void run()
	{
		final JSONTable<Payment> tablePayment  = PaymentController.paymentTable;
		final JSONTable<Product> tableProduct  = ProductController.productTable;
		final JSONTable<Store>   tableStore    = StoreController.storeTable;
		final JSONTable<Account> tableAccount  = AccountController.accountTable;
		
		while (true)
		{
			for (int i = 0; i < tablePayment.size(); ++i)
			{
				final Payment p = tablePayment.get(i);
				// calculate elapsed time
				final Record currentRecord = p.getCurrentRecord();
				final long currentTime     = System.currentTimeMillis();
				final long startingTime    = currentRecord.date.getTime();
				final long elapsedTime     = currentTime - startingTime;
				// update invoice record
				switch (currentRecord.status)
				{
				case WAITING_CONFIRMATION:
					if (elapsedTime >= WAITING_CONFIRMATION_LIMIT_MS)
						p.updateRecord(Status.FAILED, "Seller didn't response for some times");	
					break;
				case ON_PROGRESS:
					if (elapsedTime >= ON_PROGRESS_LIMIT_MS)
						p.updateRecord(Status.FAILED, "Seller didn't process the transaction for too long");
					break;
				case ON_DELIVERY:
					if (elapsedTime >= ON_DELIVERY_AUTO_PROGRESS_MS)
					{
						Account account = Algorithm.<Account>find(tableAccount, (e) -> e.id == p.buyerId);
						p.updateRecord(Status.DELIVERED, String.format("Package has been delivered to: %s", account.name));
					}			
					break;
				case DELIVERED:
					if (elapsedTime >= DELIVERED_AUTO_PROGRESS_MS)
						p.updateRecord(Status.FINISHED, "Payment has been finished");
					break;
				}
			}
		}
	}
}
