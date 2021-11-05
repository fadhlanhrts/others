package matthewJmartFH;


/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Jmart
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Jmart
     */
    public Jmart()
    {
        // initialise instance variables
        x = 0;
    }

    public static void main(String args[])
    {
        Account a = new Account(1, "steven", "rioanjing@gmail.com", "Riopepek12");
        System.out.println(a.validate());
    }
    
    public static int getPromo()
    {
        return 0;
    }
    
    public static String getCustomer()
    {
        return "oop";
    }
    
    public static float getDiscountPercentage(int before,int after)
    {
        if(before < after)
        {
            return 0.0f;
        }
        
        return((before-after)*100)/before;
    }
    
    public static int getDiscountedPrice(int price, float discountPercentage)
    {   
        int int_discountPercentage; 
        int_discountPercentage= (int)discountPercentage;
        if(discountPercentage > 100.0f)
        {
            return 0;
        }
        return (price -((int_discountPercentage*price)/100));
    }
    
    public static int getOriginalPrice(int discountedPrice, float discountedPercentage)
    {   
        return(discountedPrice*100 / (100-(int)discountedPercentage));
    }
    
    public static float getCommissionMultiplier()
    {
        return 0.05f;
    }
    
    public static int getAdjustedPrice(int price)
    {
        float commission = getCommissionMultiplier() * 100;
        
        return (price + (price*(int)commission/100));
    }
    
    public static int getAdminFee(int price)
    {   float commission = getCommissionMultiplier() * 100;
        return price * (int)commission/100; 
    }
    
    public static Product createProduct()
    {
        return null;
    }
    
    public static Coupon createCoupun()
    {
        return new Coupon("all you can eat",666,Coupon.Type.DISCOUNT,0.05f,0.05f);
    }
    
    
}
