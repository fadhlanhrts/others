package FateenJmartFH;


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

    public ProductRating()
    {
        this.total = 0;
        this.count = 0;
    }
    public void insert(int rating){
        this.total += rating;
        this.count++;
    }
    public double getAvarage() {
        if(count <= 0){
            return 0;
        }else{
            return total/count;
        }
    }
    public long getCount() {
        return count;
    }
    public long getTotal() {
        return total;
    }
}
