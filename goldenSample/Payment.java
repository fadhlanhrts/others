package goldenSample;

public class Payment extends Transaction implements FileParser
{
    public int productId;
    public ShipmentDuration shipmentDuration;

    public Payment(int id, int buyerId, Product product, ShipmentDuration shipmentDuration)
    {
        super(id, buyerId, product.storeId);
        this.productId = product.id;
        this.shipmentDuration = shipmentDuration;
    }
    public Payment(int id, int buyerId, int storeId, int productId, ShipmentDuration shipmentDuration)
    {
        super(id, buyerId, storeId);
        this.productId = productId;
        this.shipmentDuration = shipmentDuration;
    }
    @Override
    public boolean validate() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public Transaction perform() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public boolean read(String content) {
        // TODO Auto-generated method stub
        return false;
    }
}