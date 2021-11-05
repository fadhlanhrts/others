package matthewJmartFH;


/**
 * Write a description of class Coupon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coupon
{
    // instance variables - replace the example below with your own
    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public final double minimum;
    private boolean used;

    /**
     * Constructor for objects of class Coupon
     */
    public Coupon(String name,int code,Type type, double cut,double minimum)
    {
        this.name = name ;
        this.code = code ;
        this.type = type ;
        this.cut = cut   ;
        this.minimum =minimum;
        this.used = false;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean isUsed()
    {
        // put your code here
        return used;
    }
    
    public boolean canApply(PriceTag pricetag)
    {   
         if(pricetag.getAdjustedPrice() >= this.minimum && used==false)
          {
            return true;
          }
          return false;
    }
    
    public double apply(PriceTag pricetag)
    {
        this.used = true;
        if(this.type == type.DISCOUNT){
         return pricetag.getAdjustedPrice() * cut/100;
          }
        else {
            return (pricetag.getAdjustedPrice() - cut);
        }
    }
    
    enum Type{
        DISCOUNT,REBATE
    }
}
