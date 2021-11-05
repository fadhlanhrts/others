package valentinusJmartFH;

public class Jmart
{   
    public static int getPromo() {
        return 0;
    }
    
    public static String getCustomer () {
        return "oop";
    }
    
    public static float getDiscountPercentage(int before, int after) {
        //ada diskon
        if (before > after) {
            int persen = (before - after)/before;
            return persen*100;
        }
        
        //tidak ada diskon
        else return 0;
    }
    
    public static int getDiscountedPrice (int price, float discountPercentage) {
        
       float priceFloat = price;
        
        if(discountPercentage > 100.0f)
        {
            return 0;
        }
        
        float hasil = priceFloat - (priceFloat * (discountPercentage/100));
        return (int)hasil;
    }
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage)
    {
        float discountedPriceFloat = discountedPrice;
        float hargaAsli = (100.0f/(100.0f - discountPercentage)) * discountedPrice;
        return (int)hargaAsli;
    }
    

    public static float getCommissionMultiplier()
    {
        return 0.05f;
    }
    
    public static int getAdjustedPrice(int price)
    {
        float priceFloat = price;
        float hargaSebelumPotongan = priceFloat + (priceFloat * getCommissionMultiplier());
        
        return (int)hargaSebelumPotongan;
    }
    
    public static int getAdminFee(int price)
    {
        float priceFloat = price;
        float biayaAdmin = priceFloat * getCommissionMultiplier();
        return (int)biayaAdmin;
    }
    
    
    public static Coupon createCoupon()
    {
        Coupon coupon = new Coupon("COUPON", 2002, Coupon.Type.DISCOUNT, 10, 20000.0);
        return coupon;
    }    
    
    public static void main (String[]args){
        System.out.print("Hello From Eclipse");
    }
}
