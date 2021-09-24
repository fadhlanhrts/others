package goldenSample;

public class Payment extends Transaction
{
    public final int productId;
    public final ShipmentDuration shipmentDuration;

    public Payment(int id, int buyerId, Product product, ShipmentDuration shipmentDuration)
    {
        super(id, buyerId, product.store.id);
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
}