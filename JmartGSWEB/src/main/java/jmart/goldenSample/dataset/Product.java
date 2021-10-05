package jmart.goldenSample.dataset;

import jmart.goldenSample.dataset.Shipment.MultiDuration;

public class Product extends Serializable
{
    public int storeId;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public MultiDuration multiDuration;

    public Product(int storeId, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category, MultiDuration multiDuration)
    {
        this.storeId = storeId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.multiDuration = multiDuration;
        this.rating = new ProductRating();
    }
}
