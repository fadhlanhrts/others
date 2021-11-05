package MuhammadRaihanAzhariJmartFH;


/**
 * Write a description of class Recognizable here.
 *
 * @author (Muhammad Raihan Azhari)
 * @version (25 Sept 2021)
 */
public class Product 
{
    public int id;
    public int idCounter;
    public int storeId;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public Treasury priceTag;
    public ProductCategory category ;
    public ProductRating rating; 
    public Shipment multiDuration;
    
    public Product(int id, int storeId, String name, int weight, boolean conditionUsed, Treasury priceTag, ProductCategory category, Shipment multiDuration){
        this.idCounter = idCounter + 1;
        this.id = idCounter;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.category = category;
        this.priceTag = priceTag;
    }
    public Product(int id,Store store,String name, int weight, boolean conditionUsed,Treasury priceTag, ProductCategory category){
        
    }
    
    public String toString(){
        return "ID : " + this.id + "Nama : " + this.name + "Weight : " + this.weight + "Category : " + this.category + "Price tag : " + this.priceTag ;
    }
 

}
