package goldenSample;

public class Account extends Recognizable
{
    public final String name;
    public final String email;
    public final String password;

    public Account(int id, String name, String email, String password)
    {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }
}