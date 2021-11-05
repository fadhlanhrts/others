package valentinusJmartFH;

public class Payment extends Invoice implements FileParser
{
    public int productCount;
    public Shipment shipment;
    
    public Payment(int id, int buyerId, int storeId, int productId, Shipment shipment) 
    {
        super(id, buyerId, storeId);
        this.productId = productId;
        this.shipment= shipment;
    }
    
    public double getTotalPay()
    {
        return 0.0;
    }
    
    public boolean validate() 
    {
        return false;
    }
    
    public Invoice perform()
    {
        return null;
    }
}
