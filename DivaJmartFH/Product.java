package DivaJmartFH;


/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product
{
    private static int idCounter=0;
    public final int id;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    
    public Product(String name, int weight, boolean conditionUsed
    , PriceTag priceTag, ProductCategory category){
    this.rating=new ProductRating();
    this.id=idCounter++;
    this.name=name;
    this.weight=weight;
    this.conditionUsed=conditionUsed;
    this.priceTag=priceTag;
    this.category=category;
   
    
    
}
}
