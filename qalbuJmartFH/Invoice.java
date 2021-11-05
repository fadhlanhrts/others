package qalbuJmartFH;

import java.util.Date;

public class Invoice extends Recognizable implements FileParser {
    
    enum Status {
        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY,
        CPMPLAINT, FINISHED, FAILED;
    }
    
    enum Rating {
        NONE, BAD, NEUTRAL, GOOD
    }
    
    public String date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status stauts;
    
    public class Record {
        public Status status;
        public Date date;
        public String message;
    }
    
    protected Invoice (int id, int buyerId, int productId) {
        super(id);
        this.buyerId = buyerId;
        this.productId = productId;
    }
    
    public boolean read (String content){
        return false;
    }
    public Object write (){
        return null;
    }
    public Object newInstance (String content){
        return null;
    }
}