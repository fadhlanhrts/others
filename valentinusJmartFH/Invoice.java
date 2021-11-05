package valentinusJmartFH;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Invoice extends Recognizable implements FileParser
{
    public String date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating = Rating.NONE;
    public Status status = Status.WAITING_CONFIRMATION;
    public ArrayList<Record> History;
    
    public enum Rating
    {
        NONE, BAD, NEUTRAL, GOOD
    }
    
    public enum Status 
    {
        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, COMPLAINT, FINISHED, FAILED
    }
    
    protected Invoice(int buyerId, int productId, int complaintId)
    {
        super(buyerId);
        this.productId = productId;
        this.complaintId = complaintId;
        SimpleDateFormat sdf = new SimpleDateFormat("E, MM/dd/yyyy");
        this.date = sdf.format(new Date());
    }
    
    @Override
    public boolean read(String date)
    {
        date = "28092021";
        return false;
    }
    
    public double getTotalPay()
    {
        return 0.0;
    }
    
    public class Record 
    {
        public Status status;
        public Date date;
        public String message;
    }
}
