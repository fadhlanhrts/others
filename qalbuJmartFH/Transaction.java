package qalbuJmartFH;

public class Transaction {
    public enum Rating { NONE, BAD, NEUTRAL, GOOD };
    
    public String time = "Time";
    public int buyerId;
    public int storeId;
    public Rating rating;
    
    public Transaction ( int id, int buyerId, int storeId) {
        this.buyerId = buyerId;
        this.storeId = storeId;       
    }
    
    public Transaction ( int id, Account buyer, Store store) {
            
    }
}
