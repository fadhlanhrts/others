package rainJmartFH;
import java.util.Enumeration;


/**
 * Write a description of class Coupun here.
 *
 * @author rain
 * @version (a version number or a date)
 */
public class Coupon
{
    // instance variables - replace the example below with your own
    public String name;
    public int code;
    public double cut;
    public Type type;
    public double minimum;
    private boolean used;

    /**
     * Constructor for objects of class Coupun
     */
    public Coupon(String name, int code, Type type, double cut, double minimum){
        // initialise instance variables
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        this.used = false;
    }
    
    public boolean isUsed(){
        return used;
    }
    
    public boolean canApply(PriceTag pricetag){
        if(PriceTag.getAdjustedPrice() >= minimum && used == false){
            return true;
        }
        else{
            return false;
        }
    }
    
    public double apply(PriceTag pricetag){
        used = true;
        return pricetag.getAdjustedPrice()-cut;
    }

    public enum Type{
        DISCOUNT, REBATE
    }

    
}
