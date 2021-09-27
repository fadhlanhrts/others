package goldenSample;

public class Payment extends Invoice implements Conductor
{
    public Shipment shipment;
    public int productCount;

    public Payment(int id, int buyerId, int productId, int productCount, Shipment shipment)
    {
        super(id, buyerId, productId);
        this.rating = Rating.NONE;
        this.productCount = productCount;
        this.shipment = shipment;
    }


    @Override
    public double getTotalPay() {
        // TODO Auto-generated method stub
        return 0;
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
}