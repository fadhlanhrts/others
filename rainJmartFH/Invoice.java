package rainJmartFH;


/**
 * Write a description of class Invoice here.
 *
 * @author rain
 * @version (a version number or a date)
 */
public class Invoice
{
    
    public String date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;

    
    protected Invoice(int id, int buyerId, int productId)
    {
        this.complaintId = id;
        this.buyerId = buyerId;
        this.productId = productId;
        
    }
    
    
    public boolean read(String date){
        return false;
    }
    
    enum Status{
        WAITING_CONFIRMAITON, CANCELLED, ON_PROGRESS, ON_DELIVERY, COMPLAINT, 
        FINISHED, FAILED
    }
    
    enum Rating{
        NONE, BAD, NEUTRAL, GOOD
    }
}
