package BrianCJmartFH;

import java.lang.ProcessBuilder.Redirect.Type;

import java.lang.ProcessBuilder.Redirect.Type;

public class Coupon extends Recognizable{
    String name;
    int code;
    double cut, minimum;
    private boolean used;
    Type type;

    public Coupon(String name, int code, Type type, double cut, double minimum) {
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        this.used = false;
    }

    public boolean isUsed() { return this.used; }

    public boolean canApply(PriceTag priceTag) { return priceTag.getAdjustedPrice() >= minimum && !this.used; }

    public double apply(PriceTag priceTag) { return priceTag.getAdjustedPrice() - cut; }
}
