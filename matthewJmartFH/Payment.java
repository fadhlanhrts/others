package matthewJmartFH;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment extends Invoice implements Transactor
{
    // instance variables - replace the example below with your own
    public int productCount;
    public Shipment shipment;
    /**
     * Constructor for objects of class Payment
     */
    
    
    public Payment(int id, int buyerId,int storeId, int productId,int productCount
    ,Shipment shipment)
    {
        super(id, buyerId,storeId);
        this.productId = productId;
        this.shipment = shipment;
        this.productCount = productCount;
    }
    
    @Override
    public boolean validate()
    {
        return false;
    }
    
    @Override
    public double getTotalPay()
    {
        return 0.0f;
    }
    
    @Override
    public Invoice perform()
    {
        return null;
    }
}
