package goldenSample;

public class Account extends Recognizable implements FileParser {
    public String name;
    public String email;
    public String password;

    public Account(int id, String name, String email, String password) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean read(String content) {
        // TODO Auto-generated method stub
        return false;
    }

    public String toString() {
        return "name: " + name + "\nemail: " + email + "\npassword: " + password;
    }
}