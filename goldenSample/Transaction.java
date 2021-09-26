package goldenSample;

public abstract class Transaction extends Invoice
{
    public enum Rating { NONE, BAD, NEUTRAL, GOOD;};

    public Rating rating = Rating.NONE;

    public Transaction(int invoiceId, int productId, int buyerId, int productCount, Shipment shipment)
    {
        super(invoiceId, productId, buyerId, productCount, shipment);
    }

    public abstract boolean validate();
    public abstract Invoice perform();
}