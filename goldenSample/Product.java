package goldenSample;

public class Product extends Recognizable
{
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public Store store;

    public Product(int id, Store store, String name, int weight, boolean conditionUsed,  PriceTag priceTag, ProductCategory category)
    {
        super(id);
        this.store = store;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
    }
}
