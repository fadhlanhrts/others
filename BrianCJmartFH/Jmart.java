package BrianCJmartFH;

public class Jmart {
    public int getPromo() { return 0; }
    public String getCustomer() { return "oop"; }
    public float getDiscountPercentage(int before, int after) {
        if(before < after) { return 0; }
        return before - after;
    }

    public float getDiscountPrice(int price, float discountPercentage) {
        if(discountPercentage > 100.0f) { return 0; }
        return price - discountPercentage;
    }

    public int getOriginalPrice(int discountedPrice, float discountedPercentage) {
        if(discountedPrice <= 0) { return 0; }
        return discountedPrice + (int)discountedPercentage;
    }

    public float getCommisionerMultiplier() { return 0.05f; }
    public int getAdminFree(int price) { return price * (int)this.getCommisionerMultiplier(); }
    public int getAdjustedPrice(int price) { return price + this.getAdminFree(price); }
    public Product createProduct() {
        PriceTag newPriceTag = new PriceTag(100);
        ProductCategory product = ProductCategory.BOOK;
        return new Product("Buku Baru", 10, false, newPriceTag, product.BOOK);
    }

    public Coupon createCoupon() {

    }

    public ShipmentDuration createShipmentDuration() {
        
    }
    
    public static void main(String args[]) {
    	
    	System.out.print("Hello from Eclipse!");
    }
    
    
}