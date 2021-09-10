package goldenSample;

/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class PriceTag
{
    public static final float COMMISSION_MULTIPLIER = 0.05f;

    public float discount;
    public float price;

    public PriceTag(float price, float discount)
    {
        this.price = price;
        this.discount = discount;
    }

    public PriceTag(float price)
    {
        this.price = price;
        this.discount = 0.0f;
    }

    public float getAdjustedPrice()
    {
        if (discount >= 100.0f) return getAdminFee();
        float cut = price * discount / 100.0f;
        return price - cut + getAdminFee(); 
    }

    public float getAdminFee()
    {
        return COMMISSION_MULTIPLIER * price;
    }
}