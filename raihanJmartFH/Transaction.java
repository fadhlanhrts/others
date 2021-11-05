package raihanJmartFH;

public abstract class Transaction extends Recognizable
{
    public enum Rating{
        NONE,BAD,NEUTRAL,GOOD
    }

    public String time;
    public int buyerID;
    public int storeID;
    public Rating rating;    

    protected Transaction(int id, int buyerID, int storeID)
    {
        super(id);
        this.buyerID = buyerID;
        this.storeID = storeID;
        time = "Time";
        rating = rating.NONE;
    }
    
    protected Transaction(int id, Account buyer, Store store){
        super(id);
        this.buyerID = buyer.id;
        this.storeID = store.id;
    }

    public boolean validate(){
        return false;
    }
    
    public Transaction perform(){
        return null;
    }
}
