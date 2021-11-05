package fazaJmartFH;

public abstract class Transaction extends Recognizable 
{
    enum Rating
    {
    NONE, BAD, NEUTRAL, GOOD
    }
    
    public String time = "Time";
    Rating rating = Rating.NONE;
    public int buyerID;
    public int storeID;
    
    protected Transaction(int id, int buyerID, int storeID)
    {
        super(id);
        this.buyerID = buyerID;
        this.storeID = storeID;
    }
    
    protected Transaction(int id, Account buyer, Store store)
    {
        super(id);
    }
    
    public abstract boolean validate();
    public abstract Transaction perform();
}
