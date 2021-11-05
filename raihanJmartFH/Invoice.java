package RaihanJmartFH;

import java.util.Date;
import java.util.ArrayList;

public class Invoice extends Recognizable implements FileParser
{
    // instance variables - replace the example below with your own
    public Date date;
    public int buyerID;
    public int productID;
    public int complaintID;
    public Rating rating;
    public Status status;
    public ArrayList<Record> history;
    
    public static enum Status{
        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, COMPLAINT,
        FINISHED, FAILED
    }
    
    public static enum Rating{
        NONE, BAD, NEUTRAL, GOOD
    }
    
    public class Record{
        public Status status;
        public Date date;
        public String message;
    }

    protected Invoice(int id, int buyerID, int productID)
    {
        super(id);
        this.buyerID = buyerID;
        this.productID = productID;
        this.date = new Date();
        this.rating = Rating.NONE;
        this.status = status.WAITING_CONFIRMATION;
    }

    @Override
    public boolean read(String content)
    {
        return false;
    }
}
