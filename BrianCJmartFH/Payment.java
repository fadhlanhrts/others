package BrianCJmartFH;

public class Payment extends Transaction implements FileParser {
    public int productId;
    public ShipmentDuration shipmentDuration;

    public Payment(int id, int buyerId, Product product, ShipmentDuration shipmentDuration) {

    }

    public Payment(int id, int buyerId, int storeId, int productId, ShipmentDuration shipmentDuration) {

    }
}
