package valentinusJmartFH;

public abstract class Transaction extends Recognizable
{
    public String time = "Time";
    public int buyerId;
    public int storeId;
    public Rating rating = Rating.NONE;

    protected Transaction(int id, int buyerId, int storeId)
    {
        super(id);
        this.buyerId = buyerId;
        this.storeId = storeId;
    }
    
    protected Transaction(int id, Account buyer, Store store)
    {
        super(id);
    }
    
    public boolean validate() 
    {
        return true;
    }
    
    public Transaction perform() 
    {
        return null;        
    }
    
    public enum Rating
    {
        NONE, BAD, NEUTRAL, GOOD
    }
}
