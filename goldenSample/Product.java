package goldenSample;

public class Product extends Recognizable implements FileParser
{
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public int storeId;


    public Product(int id, int storeId, String name, int weight, boolean conditionUsed,  PriceTag priceTag, ProductCategory category)
    {
        super(id);
        this.storeId = storeId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
    }

    public Product(int id, Store store, String name, int weight, boolean conditionUsed,  PriceTag priceTag, ProductCategory category)
    {
        super(id);
        this.storeId = store.id;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
    }

    @Override
    public boolean read(String content) {
        // TODO Auto-generated method stub
        return false;
    }

    public String toString()
    {
        return "Name: " + name +
                "\nWeight: " + weight +
                "\nconditionUsed: " + conditionUsed +
                "\npriceTag: " + priceTag.getAdjustedPrice() +
                "\ncategory: " + category.toString() +
                "\nrating: " + rating.toString() +
                "\nstoreId: "+ storeId;


    }
}
