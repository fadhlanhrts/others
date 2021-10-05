package jmart.goldenSample.dataset;

public abstract class Invoice extends Serializable
{
    public enum Status { WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, COMPLAINT, FINISHED, FAILED }
    public enum Rating { NONE, BAD, NEUTRAL, GOOD }

    public final String date; // Modul 4 ganti jadi Date
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;

    protected Invoice(int buyerId, int productId)
    {
        this.buyerId = buyerId;
        this.productId = productId;
        this.complaintId = -1;
        this.date = "Date";
        this.rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;
    }

    public abstract double getTotalPay();
}