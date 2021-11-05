package AidanAzkafaroDesonJmartFH;


/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product extends Recognizable 
{
    // instance variables - replace the example below with your own
    private static int idCounter;
    private int id;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public int storeId;
    public Shipment.MultiDuration multiDuration;

    /**
     * Constructor for objects of class Product
     */
    public Product(int id, int storeId, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category, Shipment.MultiDuration multiDuration)
    {
        // Initialize instance variables
     
        this.storeId = storeId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        rating = new ProductRating();
        this.id = ++idCounter;
        this.multiDuration = multiDuration;
    }
    
    public String toString(){
        return "name: " + this.name + "\n" + "weight: " + this.weight + "\n" + 
        "conditionUsed: " + this.conditionUsed + "\n" + "priceTag: " + this.priceTag + "\n" 
        + "category: " + this.category + "\n" + "rating: " + this.rating + "\n" + "storeId: " + this.storeId;
    }
    public boolean read (String content){
        return false;
    }

}
