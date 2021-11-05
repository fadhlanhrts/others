package RionaldiJmartFH;

/**
 * Write a description of class PriceTag here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PriceTag
{
    public static final double COMMISSION_MULTIPLIER = 0.05;
    public static final double BOTTOM_PRICE = 20000.0;
    public static final double BOTTOM_FEE = 1000.0;
    public double discount;
    public double price;
    
    public PriceTag(double price){
        this.price = price;
        this.discount = 0.0;
    }
    
    public  PriceTag(double price, double discount){
        this.price = price;
        this.discount = discount;        
    }
    
    
    private double getDiscountedPrice(){
        double discount = this.discount;
        if (this.discount >= 100){
            discount = 100;
            return 0;
        }
        
        return this.price - ((this.price * discount)/100);
    }
    
    public double getAdminFee(){
       if (price < BOTTOM_PRICE){
           return BOTTOM_FEE;
       }
       
       return (getDiscountedPrice()*COMMISSION_MULTIPLIER);
    }
    
    public double getAdjustedPrice(){
        return (getDiscountedPrice() + getAdminFee());
    }

    
}
