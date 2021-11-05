package RionaldiJmartFH;


/**
 * Write a description of class ProductRating here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProductRating
{
    private long total;
    private long count;
    
    public ProductRating(){
        this.total = 0;
        this.count = 0;
    }
    
    public void insert(int rating){
        this.total = this.total + rating;
        this.count ++;
    }
    
    public double getAverage(){
        double average;
        if (this.count == 0){
            return average = 0;
        }
        average = this.total/this.count;
        return average;
    }
    
    public long getCount(){
        return this.count;
    }
    
    public long getTotal(){
        return this.total;
    }
}
