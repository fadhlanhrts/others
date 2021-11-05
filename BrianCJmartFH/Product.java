package BrianCJmartFH;

public class Product extends Recognizable implements FileParser {
    int idCounter=0;
    int id, weight;
    String name;
    boolean conditionUsed;
    PriceTag priceTag;
    ProductCategory category;
    ProductRating rating;

    protected Product(int id, int storeId, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category) {

    }
}