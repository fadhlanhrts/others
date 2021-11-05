package qalbuJmartFH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Store extends Recognizable implements FileParser {
    public final Pattern REGEX_PHONE = Pattern.compile("^\\d{9,12}");
    public final Pattern REGEX_NAME = Pattern.compile("^[A-Za-z]{4,20}");
    public String name;
    public String address;
    public String phoneNumber;
    
    
    public Store (int accountId, String name, String address, 
    String phoneNumber) {
        super(accountId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public void Store (Account account, String name, String address, 
    String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
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
        Store test = new Store(1, "PT Madju Merdeka", "Jl. Kukusan",
        "628777xxx");
        return "name: " + name + "\naddress: " + address + 
        "\nphoneNumber" + phoneNumber;
    }
    
    public boolean validate() {
        Matcher matcherPHONE = REGEX_PHONE.matcher (null);
        Matcher matcherNAME = REGEX_NAME.matcher (null);
        
        boolean foundPHONE = matcherPHONE.find();
        boolean foundNAME = matcherNAME.find();
        
        String resPHONE = foundPHONE ? "TRUE" : "FALSE";
        String resNAME = foundNAME ? "TRUE" : "FALSE";
        
        /*if (resPHONE == "TRUE"){
            return true;
        }else {
            return false;
        }
        
        if (resNAME == "TRUE"){
            return true;
        }else {
            return false;
        }*/
        return false;
        
    }
}