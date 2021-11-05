package valentinusJmartFH;

public class Store extends Recognizable implements FileParser
{
    public String name;
    public String address;
    public String phoneNumber; 
    public String tes; 
    public static String REGEX_PHONE;
    public static String REGEX_NAME;
    
    public Store(int accountId, String name, String address, String phoneNumber)
    {
        super(accountId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Store(Account account, String name, String address, String phoneNumber)
    {
        super(account.id);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }
    
    public boolean read(String content) 
    {
        return false;
    }
    
    public String toString()
    {
        return tes = "nyerah om aku gakuat";
    }
    
    public boolean validate(){
        if(REGEX_PHONE == "^{9,12}[0-9]$" && REGEX_NAME == "^!/\\s{2}[A-Z][a-z]{4,12}$"){
            return true;
        }else{
            return false;
        }
    }
}
