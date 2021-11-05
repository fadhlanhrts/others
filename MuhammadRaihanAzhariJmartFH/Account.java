package MuhammadRaihanAzhariJmartFH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Write a description of class Recognizable here.
 *
 * @author (Muhammad Raihan Azhari)
 * @version (25 Sept 2021)
 */
public class Account extends Recognizable 
{
    String name;
    String email;
    String password;
    Store store;
    double balance;
    
    public static final Pattern REGEX_EMAIL = Pattern.compile("^([A-Za-z0-9|.|*|~|_|&]*?)@[A-Za-z0-9][A-Za-z0-9|-|.]");
    public static final Pattern REGEX_PASSWORD = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,100}$");
    
    public Account(int id, String name, String email, String password)
    {  
       this.name = name;
       this.email = email;
       this.password = password;
       this.id = id;
    }
    
     public boolean validate(){
        Matcher matcher1 = REGEX_EMAIL.matcher(email);
        Matcher matcher2 = REGEX_PASSWORD.matcher(password);
        
        if(matcher1.find() && matcher2.find() == true){
            return true;
        }
        else{
            return false;
        }
        
        
    }
    
    
    public String toString(){
        validate();
        return "ID: "+id+" Name: "+name+" email: "+email+" password: "+password+" status_REGECX: "+ validate();
    }
   

}
