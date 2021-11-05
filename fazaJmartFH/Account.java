package fazaJmartFH;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Recognizable
{
    public String name;
    public String email;
    public String password;
    Store store;
    
    public static final Pattern REGEX_EMAIL = Pattern.compile("^\\w+([\\&_*~.]?\\w+)*@\\w+([\\.-]?\\w+)*.?\\w+$");
    public static final Pattern REGEX_PASSWORD = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");
    
    public Account(int id, String name, String email, String password)
    {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public boolean validate(){
        Matcher emailAkun = REGEX_EMAIL.matcher(email);
        Matcher passwordAkun = REGEX_PASSWORD.matcher(password);
        
        return (emailAkun.find() && passwordAkun.find() == true);
    }
}
