package MuhammadRaihanAzhariJmartFH;


/**
 * Write a description of class Coupun here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coupun
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

    
    public Coupun(String name, int code,Type type, double cut, double minimum){
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
    
    public boolean canApply(PriceTag priceTag){
        if(priceTag.getAdjustedPrice() >= minimum){
            return true;
        }
        else{
            return false;
        }
    }
    public double apply(PriceTag priceTag){
        used = true;
        return(priceTag.getAdjustedPrice() - cut);
    }
    
}
