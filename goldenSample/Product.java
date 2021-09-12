package goldenSample;

public class Product
{
    private static int idCounter = 0;

    public final int id;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public ItemCategory itemCategory;
    public PriceTag priceTag;
    public ProductRating rating;

    public Product(String name, int weight, boolean conditionUsed, ItemCategory itemCategory, PriceTag priceTag)
    {
        this.id = idCounter++;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.itemCategory = itemCategory;
        this.rating = new ProductRating();
    }
}
