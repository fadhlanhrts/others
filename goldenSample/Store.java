package goldenSample;

public class Store extends Recognizable implements FileParser
{
    public String name;
    public String address;
    public String phoneNumber;

    public Store(int accountId, String name, String address, String phoneNumber)
    {
        super(accountId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Store(Account account, String name, String address, String phoneNumber)
    {
        super(account.id);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean read(String content) {
        // TODO Auto-generated method stub
        return false;
    }
}
