package MelchiorJmartFH;

public class ProductRating {
	private long total;
	private long count;

	public void ProductRating() {
		this.total = 0;
		this.count = 0;
	}

	public void insert(int rating) {
		this.total += rating;
		this.count++;
	}

	public double getAverage() {
		return (double) this.total / this.count;
	}

	public long getCount() {
		return this.count;
	}

	public long getTotal() {
		return this.total;
	}
}
