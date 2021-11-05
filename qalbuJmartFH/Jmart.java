package qalbuJmartFH;

public class Jmart{
    public static void main (String[] args){
    //Product createProduct = new Product();
    //Coupon createCoupon = new Coupon();
    //ShipmentDuration createShipmentDuration = new ShipmentDuration();
    }
    
    public static Product create (){
        return null;
    }
    public static int getPromo(){
        return 0;
    }
    
    public static String getCustomer(){
        return "oop";
    }
    
    public static float getDiscountPercentage(int before, int after){
        if (before < after) {
            return 0;
        }else {
            return before - after;
        }
    }
    
    public static int getDiscountedPrice(int price, float getDiscountPercentage){
        int percentage = (int) getDiscountPercentage;
 
        if (getDiscountPercentage > 100) {
            return 0;
        }else {
            return ((price * 100) - (price * percentage)) / 100; 

        }
    }
    
    public static int getOriginalPrice(int getDiscountedPrice, float getDiscountPercentage){
        int percentage = 100 - (int) getDiscountPercentage;
        if (getDiscountedPrice == 0) {
            return 0;
        }else {
            return (100 * getDiscountedPrice) / percentage;
        }
    }
    
    public static float getCommisionMultiplier(){
        return 0.05f;
    }
    
    public static int getAdjustedPrice(int price){
        return (price * 105) / 100;
    }
    
    public static int getAdminFee(int price){
        return ((price * 105) / 100) - price;
    }
    

    }
    
