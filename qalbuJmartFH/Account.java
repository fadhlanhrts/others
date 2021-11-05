package qalbuJmartFH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Recognizable implements FileParser {
    public static final String REGEX_EMAIL = "^\\w+([.&`~-]?\\w+)*@\\w+([.-]?\\w+)+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";
    public String name;
    public String email;
    public String password;
    
    public Account (int id, String name, String email, String password) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public boolean read (String content){
        return false;
    }
    public Object write (){
        return null;
    }
    public Object newInstance (String content){
        return null;
    }
    
    public String toString(){
        Account test = new Account (0, "Ramadhan", 
        "ramadhanganteng@gmail.com", "gu3G4ntEng");
        return "name : " + name + "\nemail : " + email + 
        "\npassword : " + password;
    }
    
    public boolean validate(){
        Pattern regexEmail = Pattern.compile(REGEX_EMAIL);
        Matcher matcherEmail = regexEmail.matcher(email);
        
        Pattern regexPassword = Pattern.compile(REGEX_PASSWORD);
        Matcher matcherPassword = regexPassword.matcher(password);
        
        return matcherEmail.find() & matcherPassword.find();
    }
}
