package goldenSample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Store extends Recognizable implements FileParser
{
    public static final String REGEX_PHONE = "^\\d{9,12}$";
    public static final String REGEX_NAME = "^[A-Z](?!.*(\\s)\\1).{4,20}$";
    
    public String name;
    public String address;
    public String phoneNumber;


    public Store(int accountId, String name, String address, String phoneNumber) {
        super(accountId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Store(Account account, String name, String address, String phoneNumber) {
        super(account.id);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean read(String content) {
        // TODO Auto-generated method stub
        return false;
    }

    public String toString() {
        return "name: " + name + "\naddress: " + address + "\nphoneNumber: " + phoneNumber;
    }

    public boolean validate() {
        Pattern pattern = Pattern.compile(REGEX_NAME);
        Matcher matcher = pattern.matcher(name);
        Pattern pattern2 = Pattern.compile(REGEX_PHONE);
        Matcher matcher2 = pattern2.matcher(phoneNumber);
        return matcher.find() && matcher2.find();
    }

}
