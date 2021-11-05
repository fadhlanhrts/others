package valentinusJmartFH;


public class Product extends Recognizable
{
   private static int idCounter = 0;
   public int id;
   public String name;
   public int weight;
   public boolean conditionUsed;
   public PriceTag priceTag;
   public ProductCategory category;
   public ProductRating rating;
   public int storeId;
   public String tes;
   
   public Product(int id, int store, String name, int weigh, boolean conditionUsed, PriceTag priceTag, ProductCategory category){
        //this.id = idCounter++;
        super(id);
        this.storeId = storeId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
    }
        
    public boolean read (String name)
    {
        return false;
    }
    
    public String toString()
    {
        return tes = "nyerah";
    }
}
