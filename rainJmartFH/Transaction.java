package rainJmartFH;


/**
 * Write a description of class Transaction here.
 *
 * @author rain
 * @version (a version number or a date)
 */
public class Transaction
{
    public Recognizable Transaction = new Recognizable();
    
    public String time = "Time";
    public int buyerId;
    public int storeId;
    public Rating rating = NONE;

    /**
     * Constructor for objects of class Transaction
     */
    protected Transaction(int id, int buyerId, int storeId)
    {
        this.id = id;
        this.buyerId = buyerId;
        this.storeId = storeId;
    }
    
    protected Transaction(int id, Account buyer, Store store)
    {
        this.id = id;
        this.buyer = buyer;
        this.store = store;
    }

    
}

enum Rating {
    NONE, BAD, NEUTRAL, GOOD
}
