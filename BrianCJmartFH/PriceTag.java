package BrianCJmartFH;

public class PriceTag {
    final double COMMISION_MULTIPLIER = 0.05;
    final double DOUBLE_PRICE = 20000.0;
    final double BOTTOM_FEE = 1000.0;
    double discount, price;

    PriceTag(double price) {
        this.price = price;
        this.discount = 0;
    }

    PriceTag(double price, double discount) {
        this.price = price;
        this.discount = discount;
    }

    public double getAdjustedPrice() {
        return getDiscountedPrice() + getAdminFee();
    }

    public double getAdminFee() {
        if(this.getDiscountedPrice() < BOTTOM_FEE) {
            return BOTTOM_FEE;
        }
        return this.getDiscountedPrice() - (COMMISION_MULTIPLIER * this.getDiscountedPrice());
    }

    public double getDiscountedPrice() {
        if(this.discount > 100.0f) {
            return 100.0;
        } else if(this.discount == 100.0f) {
            return 0;
        }
        return this.price;
    }
}