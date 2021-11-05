package MuhammadRaihanAzhariJmartFH;


/**
 * Write a description of class Coupun here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coupon 
{
    enum Type{
        DISCOUNT, REBATE;
    }
    
    public String name;
    public int code;
    public Type type;
    public double cut;
    public double minimum;
    private boolean used;

    
    public Coupon(String name, int code,Type type, double cut, double minimum){
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
    
    public boolean canApply(Treasury priceTag){
        if(priceTag.getAdjustedPrice() >= minimum){
            return true;
        }
        else{
            return false;
        }
    }
    public double apply(Treasury priceTag){
        this.used = true;
        if(this.type == type.REBATE){
           return(priceTag.getAdjustedPrice() - this.cut); 
        }
        else{
            return ((1 - this.cut) * priceTag.getAdjustedPrice());
        }
        
    }
 
    
}
