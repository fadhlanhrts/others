package goldenSample;

public class Coupon {
    public String name;
    public int code;
    public double cut;
    public Type type;
    public double limit;

    public enum Type{
        Discount,
        Rebate
    }

    public Coupon(String name, int code, double cut, Type type, double limit){
        this.name = name;
        this.code = code;
        this.cut = cut;
        this.type = type;
        this.limit = limit;
    }

    public static double apply(PriceTag priceTag, Coupon coupon){
        if(coupon.type == Type.Rebate){
            return priceTag.getAdjustedPrice() - coupon.cut;
        } else
        {
            return priceTag.getAdjustedPrice() * coupon.cut;
        }
    }

}
