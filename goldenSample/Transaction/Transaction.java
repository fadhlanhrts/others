package goldenSample.Transaction;

import goldenSample.Account;
import goldenSample.Recognizable;
import goldenSample.Store;

public class Transaction extends Recognizable
{
    public enum Rating { NONE, BAD, NEUTRAL, GOOD };

    public final String time = "Time"; // modul 4 ganti nih jadi auto generate time
    public final int buyerId;
    public final int storeId;
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
        this.buyerId = buyer.id;
        this.storeId = store.id;
    }
}