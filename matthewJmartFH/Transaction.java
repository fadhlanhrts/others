package matthewJmartFH;


/**
 * Abstract class Transaction - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Transaction extends Recognizable
{
    // instance variables - replace the example below with your own
    public String time = "Time";
    public int buyerId;
    public int storeId;
    public Rating rating = Rating.NONE;
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    protected Transaction(int id,int buyerId, int storeId)
    {
        super(id);
        this.buyerId = buyerId;
        this.storeId = storeId;
        
    }
    
    enum Rating{
        NONE, BAD, NEUTRAL, GOOD
    }
}
