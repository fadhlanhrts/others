package RionaldiJmartFH;
import java.util.Date;
import java.util.ArrayList;

/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Invoice extends Recognizable
{
    
    public Date date;
    public int buyerId;
    public int complaintId;
    public int productId;
    public Rating rating;
    public Status status;
    public ArrayList<Record> history = new ArrayList<>();

    
    enum Status{
        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, COMPLAINT, FINISHED, FAILED
    }
    
    enum Rating{
        NONE, BAD, NEUTRAL, GOOD
    }
    
    protected Invoice(int id, int buyerId, int productId){
        this.rating = Rating.NONE;
        this.date =new java.util.Date();  
        this.status = Status.WAITING_CONFIRMATION;
        this.buyerId = buyerId;
        this.productId = productId;
    }
    
    public abstract double getTotalPay();

    
    class Record{
        public Date date;
        public String message;
        public Status status;
        
    }
         
}
