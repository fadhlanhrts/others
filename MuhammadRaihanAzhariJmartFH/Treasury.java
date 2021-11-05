package MuhammadRaihanAzhariJmartFH;


/**
 * Write a description of class PriceTag here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Treasury
{
  
    public static double COMMISSION_MULTIPLIER = 0.05;
    public static double BOTTOM_PRICE = 20000.0;
    public static double BOTTOM_FEE = 1000.0;
    public double discount;
    public double price;
    
    
    public Treasury (double price)
    {
        this.price = price;
        this.discount = 0;
    }
    
      public Treasury (double price, double discount)
    {
        this.price = price;
        this.discount = discount;
    }
    
    public double getAdjustedPrice (){
        return (getDiscountedPrice() + getAdminFee());
    }
    
    public double getAdminFee(){
        double price_after;
        price_after = getDiscountedPrice();
        if(price_after < BOTTOM_PRICE){
            price_after = BOTTOM_FEE;
        }
        else{
            price_after = price_after - (price_after * COMMISSION_MULTIPLIER);
        }
        return price_after;
    }
    
    private double getDiscountedPrice(){
        
        if(discount > 100.0){
            discount = 100.0;
        }
        if(discount == 100.0){
            return 0.0;
        }
        else{
            return (price - ((discount / 100) * price));
        }
    }
    
}
