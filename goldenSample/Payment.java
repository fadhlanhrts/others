package goldenSample;

public class Payment extends Transaction implements FileParser
{

    public Payment(int invoiceId, int productId, int buyerId, int productCount, Shipment shipment)
    {
        super(invoiceId, productId, buyerId, productCount, shipment);
    }
    public Payment(int invoiceId, Product product, int buyerId, int productCount, Shipment shipment)
    {
        super(invoiceId, product.id, buyerId, productCount, shipment);
    }

    @Override
    public boolean validate() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public Invoice perform() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public boolean read(String content) {
        // TODO Auto-generated method stub
        return false;
    }
}