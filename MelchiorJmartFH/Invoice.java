package MelchiorJmartFH;

import java.util.ArrayList;
import java.util.Date;

public abstract class Invoice extends Recognizable {
	public Date date;
	public int buyerId;
	public int productId;
	public int complaintId;
	public Rating rating;
	public Status status;
	public ArrayList<Record> history = new ArrayList<Record>();

	public enum Rating {
		NONE, BAD, NEUTRAL, GOOD
	}

	public enum Status {
		WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, COMPLAINT, FINISHED, FAILED
	}

	public class Record {
		public Status status;
		public Date date;
		public String message;
	}

	protected Invoice(int buyerId, int productId) {
		this.buyerId = buyerId;
		this.productId = productId;
		date = new Date();
		this.rating = rating.NEUTRAL;
		this.status = Status.CANCELLED;
	}

	public abstract double getTotalPay();

}
