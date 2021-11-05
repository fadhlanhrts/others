package RionaldiJmartFH;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Write a description of class Store here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Store extends Recognizable
{
    public static final String REGEX_NAME = "(^[A-Z][a-z0-9][\\S\\s]{4,20}$)";
    public static final String REGEX_PHONE = "(^[0-9]{9,12}$)";
    public String name;
    public String address;
    public double balance;
    public String phoneNumber;
    
//    public Store(int accountId, String name, String address, String phoneNumber){
//        this.name = name;
//        this.address = address;
//        this.phoneNumber = phoneNumber;
//    }
//
//    public Store(Account account, String name, String address, String phoneNumber){
//        this.name = name;
//        this.address = address;
//        this.phoneNumber = phoneNumber;
//    }

    public Store(String name, String address, String phoneNumber, double balance){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }
    

    
    public String toString() {
        return "Name: " + this.name + "\n" + "address: " + this.address+ "\n" + "phoneNumber: " + this.phoneNumber;
    }
    
    public boolean validate(){
        Pattern pattern = Pattern.compile(REGEX_NAME);
        Pattern pattern2 = Pattern.compile(REGEX_PHONE);
        Matcher matcher = pattern.matcher(this.name);
        Matcher matcher2 = pattern2.matcher(this.phoneNumber);
        if(matcher.find() == true && matcher2.find() == true){
            return true;
        }
        return false;
    }
    
    
}
