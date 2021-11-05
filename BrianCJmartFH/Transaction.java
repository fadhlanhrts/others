package BrianCJmartFH;

public class Transaction extends Recognizable {
    public String time;
    public int buyerId, storeId;
    public Rating rating;

    protected Transaction(int id, int buyerId, int storeId) {
        
    }

    protected Transaction(int id, Account buyer, Store store) {

    }
}