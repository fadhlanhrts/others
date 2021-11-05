package rainJmartFH;


public class Jmart{
    public static void main(String[] args){
        System.out.print("program berjalan");
    }
    
    public int getPromo(){
        return 0;
    }
    
    public String getCustomer(){
        return "oop";
    }
    
    public float getDiscountPercentage(int before, int after){
        float percentage;
        
        if(before < after){
            return 0;
        }
        else{
            percentage = 100 - ((after/before) * 100);
            return percentage;
        }
    }
    
    public float getDiscountedPrice(int price, float discountPercentage){
        float result = price * (discountPercentage/100);
        
        if(discountPercentage > 100){
            return 0;
        }
        else{
            return result;
        }
    }
    
    public float getOriginalPrice(int discountedPrice, float discountPercentage){
        return discountedPrice/(1 - (discountPercentage/100));
    }
    
    public float getCommissionMultyplier(){
        return 5/100;
    }
    
    public int getAdjustedPrice(int price){
        return (price*(5/100)) + price;
    }
    
    public int getAdminFee(int price){
        return price*(5/100);
    }
    
    public Product createProduct(){
        return null;
    }
    
    public Coupon createCoupon(){
        return null;
    }
    
    public ShipmentDuration createShipmentDuration(){
        return null;
    }
    
    public Product create(){
        return null;
    }
}
