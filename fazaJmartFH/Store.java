package fazaJmartFH;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Store extends Recognizable
{    
    public String name;
    public String address;
    public String phoneNumber;
    
    public static final Pattern REGEX_PHONE = Pattern.compile("^\\d{9,12}$");
    public static final Pattern REGEX_NAME = Pattern.compile("^[A-Z][A-Za-z]{3,19}$");
    
    public Store(int accountId, String name, String address, String phoneNumber)
    {
      this.name = name;
      this.address = address;
      this.phoneNumber = phoneNumber;
    }
    
    public boolean validate(){
        Matcher namaToko = REGEX_NAME.matcher(name);
        Matcher noHapeToko = REGEX_PHONE.matcher(phoneNumber);
        
        return (namaToko.find() && noHapeToko.find() == true);
    }

    public String toString()
    {
        return "nama";
    }
}
