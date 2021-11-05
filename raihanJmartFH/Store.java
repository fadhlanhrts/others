package RaihanJmartFH;

import java.util.regex.*;

public class Store extends Recognizable implements FileParser{
    public String name;
    public String address;
    public String phoneNumber;
    public static final String REGEX_NAME = "^\\d{9,12}$";
    public static final String REGEX_PHONE ="^[A-Z](?!.(\\s)\1).{4,20}$";
    
    public boolean validate() {
        Pattern phoneNumberPattern = Pattern.compile(REGEX_PHONE);
        Matcher phoneNumberMatcher = phoneNumberPattern.matcher(this.phoneNumber);
        Pattern namePattern = Pattern.compile(REGEX_NAME);
        Matcher nameMatcher = namePattern.matcher(this.name);
        
        if(phoneNumberMatcher.find() && nameMatcher.find()){
            return true;
        }
        else{
            return false;
        }
    }   
    
    public Store(int accountId, String name, String address, String phoneNumber){
        super(accountId);
        this.name = name ;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Store (Account account, String name, String address, String phoneNumber){
        super(account.id); 
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
    
    @Override
    public String toString(){
        return "name: " + this.name + "\n" + "address: " + this.address + "\n" +
        "phoneNumber: " + this.phoneNumber + "\n";
    }
}
