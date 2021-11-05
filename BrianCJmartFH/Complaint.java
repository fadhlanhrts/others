package BrianCJmartFH;
public class Complaint extends Transaction implements FileParser {
    public int paymentId;
    public String desc;
    

    public Complaint(int id, Payment payment, String desc) {

    }

    public Complaint(int id, int buyerId, int storeId, int paymentId, String desc) {

    }
}