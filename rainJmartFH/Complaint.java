package rainJmartFH;


/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint
{
    public Transaction Complaint = new Transaction();
    
    public int paymentId;
    public String desc;
    
    
    public Complaint(int id, Payment payment, String desc)
    {
        this.id = id;
        this.payment = payment;
        this.desc = desc;
    }
    
    
    public Complaint(int id, int buyerId, int storeId, int paymentId, String desc)
    {
        this.id = id;
        this.buyerId = buyerId;
        this.storeId = storeId;
        this.desc = desc;
    }
    
}
