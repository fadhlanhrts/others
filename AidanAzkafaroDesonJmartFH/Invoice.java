package AidanAzkafaroDesonJmartFH;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
/**
 * Abstract class Invoice - write a description of the class here
 *
 * @author (Aidan Azkafaro Deson)
 * @version (version number or date here)
 */
public abstract class Invoice extends Recognizable
{
    // instance variables - replace the example below with your own
    public String date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;
    public ArrayList<Record> history;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
    Calendar cal = Calendar.getInstance();
    
    public static enum Rating
    {
        NONE, BAD, NEUTRAL, GOOD;
    }
    
    public static enum Status 
    {
        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, COMPLAINT, FINISHED, FAILED;
    }
    
    protected Invoice(int id, int buyerId, int productId){
  
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = sdf.format(cal.getTime());
        this.rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;
    }
    
    public abstract double getTotalPay();
    
    public boolean read (String content){
        return false;
    };
    
    public class Record{
        public Status status;
        public Date date;
        public String message;
        
    }
}
