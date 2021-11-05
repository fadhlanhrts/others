package RaihanJmartFH;

public class ProductRating
{
    // instance variables - replace the example below with your own
    private long total;
    private long count;

    /**
     * Constructor for objects of class ProductRating
     */
    public ProductRating()
    {
        this.total = 0;
        this.count = 0;
    }

    public void insert(int rating){
        total = rating;
        count++;
    }
    
    public double getAverage(){
        return total/count;
    }
    
    public long getCount(){
        return count;
    }
    
    public long getTotal(){
        return total;
    }
}
