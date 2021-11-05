package fazaJmartFH;

enum Type
{
    DISCOUNT, REBATE
}

public abstract class Coupon extends Recognizable
{
    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public final double minimum;
    private boolean used;
    
    public Coupon(int id, String name, int code, Type type, double cut, double minimum)
    {
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this. minimum = minimum;
        this.used = false;
    }
    
    public boolean isUsed()
    {
        return used;
    }
    
    public boolean canApply(PriceTag priceTag)
    {
        if((priceTag.getAdjustedPrice() >= this.minimum) && (used == false))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public double apply(PriceTag priceTag)
    {
        this.used = true;
        if(this.type == Type.REBATE)
        {
            return priceTag.getAdjustedPrice() - this.cut;
        }
        else
        {
            return (1-this.cut)*priceTag.getAdjustedPrice();
        }
    }
}
