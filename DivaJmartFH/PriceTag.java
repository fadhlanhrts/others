package DivaJmartFH;


public class PriceTag{
public double COMMISSION_MULTIPLIER=0.05;
public double BOTTOM_PRICE =20000.0;
public double BOTTOM_FEE=1000.0;
public double discount;
public double price;



public PriceTag(double price){
double instancePrice=price;
double instanceDiscount=0.0;
}

public PriceTag(double price,double discount){
double instancePrice=price;
double instanceDiscount=discount;    
}

public double getAdjustedPrice(){
return getDiscountedPrice();
}

public double getAdminFee(){
if(price!=BOTTOM_PRICE){
return BOTTOM_FEE;}
else{
return price-(price*0.05);}
}

public double getDiscountedPrice(){
    if(discount==100){
        return 0.0;}
    if(discount>100){
        discount=100;}
    return price-(price*discount);
}



}





