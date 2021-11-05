package valentinusJmartFH;

public class Coupon
{
    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public final double minimum;
    private boolean used;
    
    public Coupon(String name, int code, Type type, double cut, double minimum)
    {
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        this.used = false;
    }
    
    public boolean isUsed() 
    {
        return used;
    }
    
    public enum Type
    {
        DISCOUNT, REBATE
    }   
    
    public boolean canApply(PriceTag priceTag)
    {
        if (priceTag.getAdjustedPrice() > minimum) 
        {
            return true;
        }
        else return false;
    }
    
    public double apply(PriceTag priceTag)
    {
        this.used = true;
        return priceTag.getAdjustedPrice() - cut;
    }
}