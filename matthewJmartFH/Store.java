package matthewJmartFH;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Write a description of class Store here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Store extends Recognizable  implements FileParser 
{
    // instance variables - replace the example below with your own
    public String name;
    public String address;
    public String phoneNumber;
    public  final String REGEX_PHONE = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$";
    public  final String REGEX_NAME  = "(^[A-Z]?[a-z0-9][\\S\\s]{4,20}$)";
    /**
     * Constructor for objects of class Store
     */
    public Store(int accountId, String name, String address, String phoneNumber)
    {
        super(accountId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        
       
    }
    
     public Store( Account account, String name, String address, String phoneNumber)
    {
        super(account.id);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean read (String Content)
    {
        return false;
    }

    public String toString() {
        return "Name: " + this.name + "\n" + "address: " + this.address+ "\n" + "phoneNumber: " + this.phoneNumber;
    }
    
    public boolean validate()
    {
        Pattern pattern1 = Pattern.compile(REGEX_NAME);
        Pattern pattern2 = Pattern.compile(REGEX_PHONE);
        Matcher matcher1 = pattern1.matcher(this.name);
        Matcher matcher2 = pattern2.matcher(this.phoneNumber);
        
        if(matcher1.find() == true && matcher2.find() == true)
        {
            return true;
        }
        
        else return false;
    }
    
}
