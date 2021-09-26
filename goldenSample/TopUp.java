package goldenSample;

public class TopUp extends Payment
{
    public enum Type{
        PLN,
        PHONE,
        OVO;
    }
    public Type type;

    public TopUp(int invoiceId, int productId, int buyerId, int productCount, Shipment shipment,Type type)
    {
        super(invoiceId, productId, buyerId, productCount, shipment);
        this.type = type;
    }

    public TopUp(int invoiceId, Product product, int buyerId, int productCount, Shipment shipment, Type type)
    {
        super(invoiceId, product, buyerId, productCount, shipment);
        this.type = type;
    }


    @Override
    public boolean read(String content)
    {
        return false;
    }

    @Override
    public boolean validate()
    {
        return false;
    }

    @Override
    public Invoice perform()
    {
        return null;
    }

}

