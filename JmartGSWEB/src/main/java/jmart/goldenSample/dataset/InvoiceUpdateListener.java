package jmart.goldenSample.dataset;

public interface InvoiceUpdateListener
{ 
	void onTransactionInit(Invoice invoice);
	void onTransactionDismissed(Invoice invoice);
}