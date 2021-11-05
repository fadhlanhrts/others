package matthewJmartFH;


/**
 * Write a description of class PriceTag here.
 *
 * @author (Matthew Eucharist)
 * @version (a version number or a date)
 */
public class PriceTag
{
    // instance variables - replace the example below with your own
    public double  discount;
    public double price;
    public static final double COMISSION_MULTIPLIER = 0.05f;
    public static final double BOTTOM_PRICE = 20000.0;
    public static final double BOTTOM_FEE = 1000.0;
    /**
     * Constructor for objects of class PriceTag
     */
    public PriceTag(double price)
    {
        
        this.price=price;
    }
    
    public PriceTag(double price, double discount)
    {
        this.price=price;
        this.discount=discount;
    }
    //end of constructor
    
    private double getDiscountedPrice()
    {
        if (this.discount > 100.0)
        {
            return 100.0;
        }
        
        else if (this.discount == 100.0)
        {
            return 0.0;
        }
        
        else
        {
            return this.price - (this.price * discount);
        }
    }
    
    public double getAdminFee()
     {
       double discounted_price = getDiscountedPrice();
       if (discounted_price < BOTTOM_PRICE)
       {
           return BOTTOM_FEE;
       }
       
       else
       {
           return discounted_price - (discounted_price * COMISSION_MULTIPLIER);
       }
     }
     
     public double getAdjustedPrice()
     {
         return getDiscountedPrice() + getAdminFee();
     }
     
     
}
