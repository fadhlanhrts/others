package rainJmartFH;


public class Product{
    private int idCounter;
    public int id = 0;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag pricetag;
    public ProductCategory category;
    public ProductRating rating;
    
    public Product(String name, int weight, boolean conditionUsed, PriceTag pricetag, ProductCategory category)
    {
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.pricetag = pricetag;
        this.category = category;
        this.idCounter++;
        this.id = this.idCounter;
    }

}
