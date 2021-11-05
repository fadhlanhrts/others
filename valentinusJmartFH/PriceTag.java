package valentinusJmartFH;

public class PriceTag
{
    public static final double COMMISSION_MIULTIPLIER = 0.05;
    public static final double BOTTOM_PRICE = 20000.0;
    public static final double BOTTOM_FEE = 1000.0;
    
    public double discount;
    public double price;
    
    /**
     * Constructor for objects of class PriceTag
     */
    public PriceTag(double price)
    {
        price = price;
        discount = 0.0;
    }

    public PriceTag(double price, double discount)
    {
        price = price;
        discount = discount;
    }
    
    public double getAdjustedPrice() 
    {
        return getAdjustedPrice() + getAdminFee();
    }
    
    public double getAdminFee()
    {
        if (getAdjustedPrice() < BOTTOM_PRICE) {
            return BOTTOM_FEE;
        }
        else return getAdjustedPrice() - (getAdjustedPrice() * COMMISSION_MIULTIPLIER);
    }
    
    private double getDiscountedPrice()
    {
        if (discount >= 100.0) {
            return 0.0;
        }
        else return price - (discount * price);
    }
}
