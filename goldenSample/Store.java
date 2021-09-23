package goldenSample;

public class Store extends Recognizable
{
    public final String name;
    public final String address;
    public final String phoneNumber;
    public Product product;

    public Store(Account account, String name, String address, String phoneNumber)
    {
        super(account.id);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
