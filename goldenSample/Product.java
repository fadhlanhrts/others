package goldenSample;

import goldenSample.Shipment.MultiDuration;

public class Product extends Recognizable implements FileParser
{
    public int storeId;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public MultiDuration multiDuration;

    public Product(int id, int storeId, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category, MultiDuration multiDuration)
    {
        super(id);
        this.storeId = storeId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.multiDuration = multiDuration;
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
