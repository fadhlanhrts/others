package qalbuJmartFH;

public class Coupon /*extends Recognizable*/ implements FileParser {
    final String name;
    final int code;
    final double cut;
    final Type type;
    final double minimum;
    public boolean used = false;
    
    public Coupon (String name, int code, Type type, double cut,
    double minimum) {
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
    }
    
    public boolean isUSed (){
        return used;
    }
    
    /*public boolean canApply (PriceTag priceTag) {
        if ( PriceTag.getAdjustedPrice(double., double.class) >= minimum ) {
            return true;
        }
        else{
            return false;
        }   
    }*/
    
    /*public double apply (PriceTag priceTag) {
        this.used = true;
        return PriceTag.getAdjustedPrice()/ cut;
    }*/
    
    public boolean read (String content){
        return false;
    }
    public Object write (){
        return null;
    }
    public Object newInstance (String content){
        return null;
    }
    
    
}
