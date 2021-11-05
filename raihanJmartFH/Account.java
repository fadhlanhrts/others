package RaihanJmartFH;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Recognizable implements FileParser
{
    public String name;
    public String email;
    public String password;
    public static final String REGEX_EMAIL = "^\\w+([.&`~-]?\\w+)*@\\w+([.-]?\\w+)+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";
    
    public Account(int id, String name, String email, String password)
    {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
    
    public String toString(){
        return this.name + this.email + this.password;
    }
    
    public boolean validate(){
        Pattern patternPhone = Pattern.compile(REGEX_EMAIL);
        Matcher matcherPhone = patternPhone.matcher(email);
        boolean matchPhone = matcherPhone.find();
        boolean hasilPhone = matchPhone ? true : false;
        Pattern patternPassword = Pattern.compile(REGEX_PASSWORD);
        Matcher matcherPassword = patternPhone.matcher(password);
        boolean matchPassword = matcherPassword.find();
        boolean hasilPassword = matchPassword ? true : false;
        
        if (hasilPhone == true && hasilPassword == true){
            return true;
        }
        else
            return false;
    }
}
