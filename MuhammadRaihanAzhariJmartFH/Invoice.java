package MuhammadRaihanAzhariJmartFH;


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
  
    enum Status{
        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, COMPLAINT, FINISHED, FAILED;
    }
    enum Rating{
        NONE, BAD, NEUTRAL, GOOD;
    }
    
    
    public Date date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;
    public ArrayList <Record> history;
    
    class Record{
        public Status status;
        public Date date;
        public String message;
    }
    
    protected Invoice(int id, int buyerId, int productId){
        this.buyerId = buyerId;
        this.productId = productId;
        this.complaintId = complaintId;
        date = new Date();
        rating = rating.NONE;
        status = status.WAITING_CONFIRMATION;
    }
    
    
    public double getTotalPay(){
        return 0.0;
    }
    
  
    
    
}
