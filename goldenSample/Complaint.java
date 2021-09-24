package goldenSample;

public class Complaint extends Transaction
{
    public final int paymentId;
    public final String desc;

    public Complaint(int id, Payment payment, String desc)
    {
        super(id, payment.buyerId, payment.storeId);
        this.paymentId = payment.id;
        this.desc = desc;
    }
    public Complaint(int id, int buyerId, int storeId, int paymentId, String desc)
    {
        super(id, buyerId, paymentId);
        this.paymentId = paymentId;
        this.desc = desc;
    }
}