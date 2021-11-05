package qalbuJmartFH;

 public class  Product extends Recognizable implements FileParser{
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public int storeId;
    public Shipment.MultiDuration multiduration;
    
    public Product (int id, int storeId, String name, int weight,
    boolean conditionUsed, PriceTag priceTag, ProductCategory category,
    Shipment.MultiDuration multiDuration) {
        super(id);
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
        
    }
    
    public Product (int id, Store storeId, String name, int weight,
    boolean conditionUsed, PriceTag priceTag, ProductCategory category) {
        super(id);
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
    }
    
    public boolean read (String content){
        return false;
    }
    public Object write (){
        return null;
    }
    public Object newInstance (String content){
        return null;
    }
    
    public String toString() {
        //Product test = new Product (0, 0, "Harry Potter", 1, 
        //false, 21000, "B00K", 0);
        return null;
    }
}