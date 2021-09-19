package goldenSample;

public class Store {
    private static int idCounter = 0;
    public final int id;
    public String storeName;
    public String storeDesc;
    public String address;
    public StoreCategory category;
    public int storeRating;
   
    public Store(String storeName, String storeDesc, String address, StoreCategory category, int storeRating)
    {
        this.id = idCounter++;
        this.storeName = storeName;
        this.storeDesc = storeDesc;
        this.address = address;
        this.category = category;
        this.storeRating = storeRating;
    }
}
