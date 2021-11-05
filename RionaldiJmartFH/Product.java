package RionaldiJmartFH;


/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product extends Recognizable
{
     public int storeId;
     public String name;
     public int weight;
     public boolean conditionUsed;
     public PriceTag priceTag;
     public ProductCategory category;
     public ProductRating rating;
     public Shipment.MultiDuration multiDuration;
     
     

    public Product(int id, int storeId, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category, Shipment.MultiDuration multiDuration){
        this.storeId = storeId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = rating;
        this.multiDuration = multiDuration;
        
    
    }

    
   public String toString() {
        return "Name: " + this.name + "\n" + "Weight: " + this.weight + "\n" + "conditionUsed: " + this.conditionUsed + "\n" + "priceTag: " + this.priceTag.getAdjustedPrice() + "\n" + "category: " + this.category + "\n" + "rating: " + this.rating + "\n" + "storeId" + this.storeId + "\n";
    }
    

}


