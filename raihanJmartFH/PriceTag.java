package RaihanJmartFH;


/**
 * Write a description of class PriceTag here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PriceTag
{
    double COMMISSION_MULTIPLIER = 0.05;
    double BOTTOM_PRICE = 20000.0;
    double BOTTOM_FEE = 1000.0;
    double discount;    
    double price;

    public PriceTag(double price){
       this.price = price;
       this.discount = 0.0; 
    }
    
    public PriceTag(double price, double discount){
        this.price = price;
        this.discount = discount;
    }
    
    public double getAdjustedPrice(){
        return getDiscountedPrice() + getAdminFee();
    }
    
    public double getAdminFee(){
        if(getDiscountedPrice()<BOTTOM_PRICE){
            return BOTTOM_FEE;
        }
        return getDiscountedPrice()-(price*COMMISSION_MULTIPLIER);
    }
    
    public double getDiscountedPrice(){
        if (discount > 100.0){
            discount = 100.0;
        }
        else if(discount == 100.0){
            discount = 0.0;
        }
        return price-discount;
    }
}
