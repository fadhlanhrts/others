package qalbuJmartFH;

public class PriceTag {
    final static double COMMISSION_MULTIPLIER = 0.05;
    final static double BOTTOM_PRICE = 20000.0;
    final static double BOTTOM_FEE = 1000.0;
    double discount;
    double price;
    
    public PriceTag (double price) {
        this.price = price;
    }
    
    public PriceTag (double price, double discount) {
        this.price = price;
        this.discount = discount;
    }
    
    public static double getAdjustedPrice(double getDiscountedPrice,
    double getAdminfee) {
        return getDiscountedPrice + getAdminfee;
    }
    
    public static double getAdminFee(double price, double discount) {
        double fixPrice = (price * (100 - discount)) / 100;
        if (fixPrice < BOTTOM_PRICE) {
            return BOTTOM_PRICE * (1 - COMMISSION_MULTIPLIER);
        }else {
            return fixPrice * (1 - COMMISSION_MULTIPLIER);
        }
    }
    
    private static double getDiscountedPrice(double price, double discount) {
        if (discount > 100 ) {
            return 0;
        } else {
            return price * (100 - discount);
        }
    }
}
