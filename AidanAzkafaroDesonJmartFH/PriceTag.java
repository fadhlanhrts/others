package AidanAzkafaroDesonJmartFH;


/**
 * Write a description of class PriceTag here.
 *
 * @author (Aidan Azkafaro Deson)
 * @version (18/9/21)
 */
public class PriceTag
{
    // instance variables - replace the example below with your own
    public static final double COMMISSION_MULTIPLIER = 0.05;
    public static final double BOTTOM_PRICE = 20000.0;
    public static final double BOTTOM_FEE = 1000.0;
    public double discount;
    public double price;

    /**
     * Constructor for objects of class PriceTag
     */
    public PriceTag(double price)
    {
        // initialise instance variables
        this.price = price;
        this.discount = 0.0;
    }

    public PriceTag(double price, double discount)
    {
        // initialise instance variables
        this.price = price;
        this.discount = discount;
    }

    public double getAdjustedPrice()
    {
        return getDiscountedPrice() + getAdminFee();
    }

    public double getAdminFee()
    {
        if(getDiscountedPrice() < BOTTOM_PRICE)
        {
            return BOTTOM_FEE;
        }
        
        return (getDiscountedPrice()*COMMISSION_MULTIPLIER);
        
        
    }   
    
    private double getDiscountedPrice()
    {
        if(discount > 100.0)
        {
            discount = 100.0;
        }else if(discount == 100.0)
        {
            return 0.0;
        }
        
        return price - (price*discount);
        
        
    }
}
