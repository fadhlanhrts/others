package rainJmartFH;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment
{
    public Transaction Payment = new Transaction();
    
    public int porductId;
    public ShipmentDuration shipmentDuration;

    
    public Payment(int id, int buyerId, Product product, ShipmentDuration shipmentDuration)
    {
        this.id = id;
        this.buyerId = buyerId;
        this.product = product;
        this.shipmentDuration = shipmentDuration;
    }
    
    
    public Payment(int id, int buyerId, int storeId, int produceId, ShipmentDuration shipmentDuration)
    {
        this.id = id;
        this.buyerId = buyerId;
        this.produceId = produceId;
        this.shipmentDuration = shipmentDuration;
    }

    
}
