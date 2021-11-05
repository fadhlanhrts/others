package RionaldiJmartFH;


/**
 * Write a description of class Coupon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coupon extends Recognizable
{
    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public final double minimum;
    private  boolean used;
    
    Coupon(int id, String name, int code, Type type, double cut, double minimum){
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        this.used = false;
    }
    
    boolean isUsed(){
        return this.used;
    }
    
    public boolean canApply(PriceTag priceTag){
        if((priceTag.getAdjustedPrice() >= this.minimum) && (this.used == false)){
            return true;
        } else{
            return false;
        }
    }
    
    public double apply(PriceTag priceTag){
         this.used = true;

         if(this.type == Type.DISCOUNT){
                return (priceTag.getAdjustedPrice() - (priceTag.getAdjustedPrice()* this.cut/100));
             }     
          
         return (priceTag.getAdjustedPrice() - this.cut);
        
    }

}
