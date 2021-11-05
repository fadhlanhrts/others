package DivaJmartFH;


/**
 * Write a description of class Transaction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Transaction
{public String time;
    public int buyer;
    public int storeId;
    public Rating rating;
    
    protected Transaction(int id, int buyerId, 
    int storeId){}
    
    protected Transaction(int id, Account buyer, Store store){}
    public boolean validate(){}
    public Transaction perform(){}
    
    
}
