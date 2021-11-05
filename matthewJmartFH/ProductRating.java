package matthewJmartFH;


/**
 * Write a description of class ProductRating here.
 *
 * @author (Matthew Eucharist)
 * @version (a version number or a date)
 */
public class ProductRating
{
    // instance variables - replace the example below with your own
    long total;
    long count;

    /**
     * Constructor for objects of class ProductRating
     */
    public ProductRating()
    {
        // initialise instance variables
        total = 0;
        count = 0;
    }
    //end of constructor
  
    public void insert(int rating)
    {
        // put your code here
        total = total + rating;
        count++;
    }
    
    public double getAverage()
    {
            
         return total/count;
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
