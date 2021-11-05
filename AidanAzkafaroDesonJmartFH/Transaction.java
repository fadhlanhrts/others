package AidanAzkafaroDesonJmartFH;


/**
 * Write a description of class Transaction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Transaction extends Recognizable
{
    // instance variables - replace the example below with your own
    public String time = "Time";
    public int buyerId;
    public int storeId;
    public Rating rating = Rating.NONE;

    enum Rating {
        NONE, BAD, NEUTRAL, GOOD
    }
    /**
     * Constructor for objects of class Transaction
     */
    protected Transaction(int id, int buyerId, int storeId)
    {
        // initialise instance variables
        super(id);
        this.buyerId = buyerId;
        this.storeId = storeId;
        time = "Time";
        rating = Rating.NONE;
    }
    
    protected Transaction(int id, Account buyer, Store store)
    {
        // initialise instance variables
        super(id);
       
    }
  
}
