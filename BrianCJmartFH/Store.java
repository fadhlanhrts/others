package BrianCJmartFH;

public class Store extends Recognizable implements FileParser {
    public String name, address, phoneNumber;
    public Store(int accountId, String name, String address, String phoneNumber) {

    }

    public Store(Account account, String name, String address, String phoneNumber) {

    }

    public boolean read(String name) {
        return true;
    }
}
