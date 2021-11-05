package RaihanJmartFH;

public class Payment extends Invoice implements Transactor
{
    public int productId;
    public Shipment shipment;

    public Payment(int id, int buyerId, Product product, Shipment shipment)
    {
        super(id, buyerId, product.storeID);
        this.productId = product.id;
        this.shipment = shipment;
    }

    public double getTotalPay(){
        return 0.0;
    }

    public boolean validate(){
        return false;
    }

    public Invoice perform(){
        return null;
    }
}
