package DivaJmartFH;

public class ProductRating{
    private long total;
    private long count;
    
    public ProductRating(){
        this.total=0;
        this.count=0;
    }
    
    public void insert(int rating){
        this.total+=rating;
        this.count++; 
    }
    public double getAverage(){
    if(this.count!=0)
    {double AvgRating=this.total/this.count;
    return AvgRating;}
    else {
    return 0.0;}}
    
    public long getCount(){
    return this.count;}   
    public long getTotal(){
    return this.total;}

}

