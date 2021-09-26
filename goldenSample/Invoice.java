package goldenSample;

public class Invoice extends Recognizable
{
    public int productId;
    public int productCount;
    public int buyerId;
    public Shipment shipment;
    protected String invoiceStatus;
    public String date; // Modul 4 ganti jadi Date

    public Invoice(int invoiceId, int productId, int buyerId, int productCount, Shipment shipment)
    {
        super(invoiceId);
        this.productId = productId;
        this.buyerId = buyerId;
        this.productCount = productCount;
        this.shipment = shipment;
    }

    public String getInvoiceStatus()
    {
        return invoiceStatus;
    }
}
