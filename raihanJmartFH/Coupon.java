package RaihanJmartFH;

public class Coupon
{
    public final String name;
    public final int code;
    public final double cut;
    Type type;
    public  final double minimum;
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
        return this.used;
    }
    
    public boolean canApply(PriceTag priceTag){
        if (priceTag.getAdjustedPrice() >= minimum && used == false){
            return true;
        }
        else{
            return false;
        }
    }
    
    public double apply(PriceTag priceTag){
        double tempPrice = priceTag.getAdjustedPrice();
        used = true;
        switch (type){
            case DISCOUNT:
                System.out.println(priceTag.discount);
                return tempPrice - ((tempPrice * priceTag.discount) / 100);
            case REBATE:
                System.out.println((tempPrice * priceTag.discount) / 100);
                return tempPrice - ((tempPrice * priceTag.discount) /100);
        }
        return tempPrice - ((tempPrice * priceTag.discount) / 100);
    }
    
    public enum Type{
    DISCOUNT, REBATE
    };
}



