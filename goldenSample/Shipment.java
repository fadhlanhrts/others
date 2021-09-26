package goldenSample;

public class Shipment
{
    public String address;
    public int shipmentCost;
    public ShipmentDuration duration;
    public String receipt;

    public Shipment(String address, int shipmentCost, ShipmentDuration duration, String receipt)
    {
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
    }

}
