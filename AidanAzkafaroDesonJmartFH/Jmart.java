package AidanAzkafaroDesonJmartFH;


/**
 *
 * @author (Aidan Azkafaro Deson)
 * 
 */
public class Jmart
{

    public static int getPromo()
    {
        return 0;
    }
    
    public static String getCustomer()
    {
        return "oop";
    }
    
    public static float getDiscountPercentage(int before, int after)
    {
        float beforeFloat = before;
        float afterFloat = after;
        
        if(before < after)
        {
            return 0.0f;
        }
        return  ((beforeFloat-afterFloat)/beforeFloat)*100.0f;
    }
    
    public static int getDiscountedPrice(int price, float discountPercentage)
    {
        
        float priceFloat = price;
        
        if(discountPercentage > 100.0f)
        {
            return 0;
        }
        float hasil = priceFloat - (priceFloat * (discountPercentage/100));
        int hasilInt = (int)hasil;
        return hasilInt;
    
    } 
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage)
    {
        float discountedPriceFloat = discountedPrice;
        float hasil = (100.0f/(100.0f - discountPercentage)) * discountedPrice;
        return (int)hasil;
    }
    

    public static float getCommissionMultiplier()
    {
        return 0.05f;
    }
    
    public static int getAdjustedPrice(int price)
    {
        float priceFloat = price;
        float hasil = priceFloat + (priceFloat * getCommissionMultiplier());
        
        return (int)hasil;
    }
    
    public static int getAdminFee(int price)
    {
        float priceFloat = price;
        float hasil = priceFloat * getCommissionMultiplier();
        return (int)hasil;
    }
    public static Shipment.Duration shipmentDuration(){
        return null;
    }
    public static Product create()
    {
        PriceTag price = new PriceTag(10000.0);
        Shipment.MultiDuration multiDuration = new Shipment.MultiDuration();
        Product product = new Product(1, 10, "Baju Nike", 1, true, price, ProductCategory.FASHION, multiDuration);
        return product;
    }
    
    public static Product createProduct()
    {   
        PriceTag price = new PriceTag(100000.0);
        Shipment.MultiDuration multiDuration = new Shipment.MultiDuration();
        Product product = new Product(1, 10, "Sepatu", 1, false , price, ProductCategory.FASHION, multiDuration);
        return product;
    }
    
    public static Coupon createCoupun()
    {
        Coupon coupon = new Coupon(1, "sebuah coupon", 14045 , Coupon.Type.DISCOUNT, 10, 20000.0);
        return coupon;
    }
    
   
    public static void main (String[]args){
        Complaint complaint = new Complaint(10, "Failed to pay");
        System.out.println(complaint.toString());
        
        Account account = new Account(1, "ahmad", "ahmaddhani@gmail.com", "ahmad1010");
        System.out.println(account.validate());
        
        System.out.println("Hello from Eclipse!");
    }
    
}
