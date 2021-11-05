package RionaldiJmartFH;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Account extends Recognizable
{
    public String name;
    public String email;
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9_&_*~]+(?:\\.[a-zA-Z0-9_&_*~]+)*@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9-]+)*$";
    public static final String REGEX_PASSWORD = "^(?=.*\\d)(?=.*[a-zA-Z])[a-zA-Z0-9]{8,}$";
    public String password;
    public double balance;
    public Store store;
    
    
    public Account(String name, String email, String password, double balance){
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }
    

    
    public String toString() {
        return "Name: " + this.name + "\n" + "email: " + this.email+ "\n" + "password: " + this.password;
    }
    
    public boolean validate(){
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Pattern pattern2 = Pattern.compile(REGEX_PASSWORD);
        Matcher matcher = pattern.matcher(this.email);
        Matcher matcher2 = pattern2.matcher(this.password);
        if(matcher.find() == true && matcher2.find() == true){
            return true;
        } 
        return false;
    }

}
