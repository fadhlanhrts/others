package AidanAzkafaroDesonJmartFH;


/**
 * Write a description of class ProductRating here.
 *
 * @author (Aidan Azkafaro Deson)
 * @version (a version number or a date)
 */
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
        // initialise instance variables
        this.total = 0;
        this.count = 0;
    }

    public void insert(int rating)
    {
        // put your code here
        this.total = total + rating;
        this.count = count + 1;
    }
    
    public double getAverage()
    {
        if(count == 0)
        {
            return 0.0;
        }
        return (double)(total/count);
    }
    
    public long getCount()
    {
        return count;
    }

    public long getTotal()
    {
        return total;
    }
}
