package goldenSample;

public class Product {

    public ItemCategory itemCategory;
    public PriceTag priceTag;
    public String name;

    private static int productCount = 0;

    public Product(String name, PriceTag priceTag, ItemCategory itemCategory)
    {
        this.name = name;
        this.priceTag = priceTag;
        this.itemCategory = itemCategory;
        productCount++;
    }

    public Product(Product product)
    {
        this.name = product.name;
        this.priceTag = product.priceTag;
        this.itemCategory = product.itemCategory;
        productCount++;
    }

    public static int getProductCount(){return productCount;}
}
