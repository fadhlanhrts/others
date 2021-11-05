package matthewJmartFH;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Account extends Recognizable implements FileParser
{
    // instance variables - replace the example below with your own
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9_&_*~]+(?:\\.[a-zA-Z0-9_&_*~]+)*@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9-]+)*$";
    public static final String REGEX_PASSWORD ="^(?=.*\\d)(?=.*[a-zA-Z])[a-zA-Z0-9]{7,}$";
    public String name;
    public String email;
    public String password;
    /**
     * Constructor for objects of class Account
     */
    public Account(int id, String name, String email, String password)
    {   
        super(id);
        this.name  = name;
        this.email = email;
        this.password = password;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    @Override
    public boolean read(String name)
    {
        // put your code here
        return false;
    }
    
    public String toString() {
        return "Name: " + this.name + "\n" + "email: " + this.email+ "\n" + "password: " + this.password;
    }
    
    public boolean validate()
    {
        Pattern email = Pattern.compile(REGEX_EMAIL);
        Pattern password = Pattern.compile(REGEX_PASSWORD);
        Matcher email_matcher = email.matcher(this.email);
        Matcher pass_matcher = password.matcher(this.password);
        
        if(email_matcher.find() == true && pass_matcher.find() == true)
        {
            return true;
        }
        
        else return false;
    }
}
