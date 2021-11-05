package rainJmartFH;


/**
 * Write a description of class Store here.
 *
 * @author rain
 * @version (a version number or a date)
 */
public class Store
{
    public Recognizable Store = new Recognizable();
    
    public String nama;
    public String address;
    public String phoneNumber;

    /**
     * Constructor for objects of class Store
     */
    public Store(int accountId, Sting name, String address, String phoneNumber)
    {
        this.accountId = accountId;
        this.nama = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public Store(Account account, String name, String address, String phoneNumber)
    {
        this.account = account;
        this.nama = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    
}
