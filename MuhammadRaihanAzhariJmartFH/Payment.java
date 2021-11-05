package MuhammadRaihanAzhariJmartFH;


/**
 * Write a description of class Recognizable here.
 *
 * @author (Muhammad Raihan Azhari)
 * @version (25 Sept 2021)
 */
public class Payment extends Invoice
{
   
    public int productCount;
    public Shipment shipment;
  
    public Payment(int id, int buyerId, int productId, int productCount, Shipment shipment){
        super(id, buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }
    
    public Invoice perform(){
        return null;
    }
    
    public double getTotalPay(){
        return 0.0;
    }
    public boolean validate(){
        return true;
    }
   

   
}
