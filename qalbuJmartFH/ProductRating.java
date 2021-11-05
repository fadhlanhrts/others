package qalbuJmartFH;

public class ProductRating {
    private long total;
    private long count;
    
    public ProductRating() {
        this.total = 0;
        this.count = 0;
    }
    
    public void insert (int rating) {
        total += rating;
        count ++;
    }
    
    public double getAverage () {
        try {
        return total / count;
        }
        catch (ArithmeticException e) {
            return 0;
        }
    }
    
    public double getCount () {
        return count;
    }
    
    public double getTotal () {
        return total;
    }
    
}

