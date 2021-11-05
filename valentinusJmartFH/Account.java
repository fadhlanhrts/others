package valentinusJmartFH;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Recognizable implements FileParser
{
    public String name;
    public String email;
    public String password;
    public static String REGEX_EMAIL = "^\\w+([\\&_*~.]?\\w+)*@\\w+([\\.-]?\\w+)*.?\\w+$";
    public static String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";
    
    public Account(int id, String name, String email, String password)
    {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean read(String content)
    {
        return false;
    }
    
    public String toString()
    {
        return "name: " + this.name + "\n" + "email: " + this.email + "\n" +"password: " + this.password;
    }
    
    public boolean validate(){
        Pattern syaratEmail = Pattern.compile(REGEX_EMAIL);
        Matcher bandingEmail = syaratEmail.matcher(email);
        boolean cekEmail = bandingEmail.find();
        boolean hasilEmail = cekEmail ? true : false;
        
        Pattern syaratPass = Pattern.compile(REGEX_PASSWORD);
        Matcher bandingPass = syaratPass.matcher(password);
        boolean cekPass = bandingPass.find();
        boolean hasilPass = cekPass ? true : false;
        
        if(hasilEmail && hasilPass){
            return true;
        }
        return false;
        
    }
}
