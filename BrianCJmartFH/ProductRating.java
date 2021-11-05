package BrianCJmartFH;

public class ProductRating {
    long total, count;

    ProductRating() {
        this.total = 0;
        this.count = 0;
    }

    public void insert(int rating) {
        this.total += rating;
        this.count++;
    }

    public double getAverage() {
        if(count == 0) {
            return 0;
        }
        return total/count;
    }

    public long getCount() { return this.count; }
    public long getTotal() { return this.total; }
}