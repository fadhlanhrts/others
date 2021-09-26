package goldenSample;

public class GameVoucher extends Payment
{
    public enum Type{
        VALORANT,
        STEAM,
        GENSHIN_IMPACT;
    }
    public Type type;

    public GameVoucher(int invoiceId, int productId, int buyerId, int productCount, Shipment shipment, Type type)
    {
        super(invoiceId, productId, buyerId, productCount, shipment);
        this.type = type;
    }

    public GameVoucher(int invoiceId, Product product, int buyerId, int productCount, Shipment shipment, Type type)
    {
        super(invoiceId, product, buyerId, productCount, shipment);
        this.type = type;
    }


    @Override
    public boolean read(String content) {
        return false;
    }

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public Invoice perform() {
        return null;
    }

}
