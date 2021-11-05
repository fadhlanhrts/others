package fazaJmartFH;

public class Product extends Recognizable
{
    public int storeId;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public Shipment.Duration multiDuration;
    
    public Product(int id, int storeId, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category, Shipment.Duration multiDuration)
    {
        this.storeId = storeId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
        this.multiDuration = multiDuration;
    }
    
    public String toString()
    {
        Product product = new Product(44, 6464, "Buku gambar", 4, false, new PriceTag(15000), ProductCategory.BOOK, Shipment.Duration.REGULER);
        return product.name;
    }
}
