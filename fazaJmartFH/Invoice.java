package fazaJmartFH;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public abstract class Invoice extends Recognizable
{
    public final Date date;
    ArrayList<Record> history = new ArrayList<Record>();
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;
    
    public static enum Rating
    {
        NONE, BAD, NEUTRAL, GOOD
    }
    
    public static enum Status
    {
        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, COMPLAINT, FINISHED, FAILED
    }
    
    protected Invoice(int id, int buyerId, int productId)
    {
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = new Date();
        rating = Rating.NONE;
        status = Status.WAITING_CONFIRMATION;
    }
    
    public class Record
    {
        public Date date;
        public String message;
        public Status status;
    }
}
