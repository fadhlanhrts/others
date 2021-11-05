package AidanAzkafaroDesonJmartFH;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Recognizable
{
    
    // instance variables - replace the example below with your own
    public String name;
    public String email;
    public String password;
    public static String REGEX_EMAIL = "^\\w+([\\&_*~.]?\\w+)*@\\w+([\\.-]?\\w+)*.?\\w+$";
    public static String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";
  
    public Account (int id, String name, String email, String password){
        
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public boolean read (String string){
        return false;
    }
    
    public String toString(){
        return "name: " + this.name + "\n" + "email: " + this.email + "\n" + "password: " + this.password;
    }
  
    public boolean validate(){
        Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
        Matcher matcherEmail = patternEmail.matcher(email);
        boolean matchFoundEmail = matcherEmail.find();
        boolean emailResult = matchFoundEmail ? true : false;
        
        Pattern patternPassword = Pattern.compile(REGEX_PASSWORD);
        Matcher matcherPassword = patternPassword.matcher(password);
        boolean matchFoundPassword = matcherPassword.find();
        boolean passwordResult = matchFoundPassword ? true : false;
        
        if(emailResult && passwordResult){
            return true;
        }
        return false;
        
    }
}
