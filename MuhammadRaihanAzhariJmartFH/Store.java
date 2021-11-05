package MuhammadRaihanAzhariJmartFH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * Write a description of class Recognizable here.
 *
 * @author (Muhammad Raihan Azhari)
 * @version (25 Sept 2021)
 */
public class Store extends Recognizable
{
    
    public String name;
    public String address;
    public String phoneNumber;
    public double balance;
    
    
    public static final Pattern REGEX_PHONE = Pattern.compile("^[0-9]{9,12}$");
    public static final Pattern REGEX_NAME = Pattern.compile("^[A-Z][A-Za-z| ]{3,19}$");
    
    
  
    public Store(String name,String address, String phoneNumber, double balance){
       this.name = name;
       this.address = address;
       this.phoneNumber = phoneNumber;
       this.balance = balance;
         
    }

    
    public boolean validate(){
        Matcher matcher1 = REGEX_NAME.matcher(name);
        Matcher matcher2 = REGEX_PHONE.matcher(phoneNumber);
        
        if(matcher1.find() && matcher2.find() == true){
            return true;
        }
        else{
            return false;
        }
        
        
    }
   

   
}
