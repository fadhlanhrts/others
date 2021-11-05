package RaihanJmartFH;

public class Product extends Recognizable implements FileParser{
    private int idCounter;
    public int id;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public int storeID;
    public Shipment.MultiDuration multiDuration;

    public Product(int id, int storeID, String name, int weight, boolean conditionUsed, 
    PriceTag priceTag, ProductCategory category){
        super(id);
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.multiDuration = multiDuration;
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
} 
