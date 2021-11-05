package valentinusJmartFH;

public class ProductRating 
{
    private long total;
    private long count;
    
    public ProductRating() {
        total = 0;
        count = 0;
    }
    
    public void Insert(int rating) {
        total += rating;
        count++;
    }
    
    public double getAverage() {
        return (double)(total/count);
    }
    
    public long getCount() {
        return count;
    }
    
    public long getTotal() {
        return total;
    }
}