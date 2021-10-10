package jmart.goldenSample.dataset;

import jmart.goldenSample.dataset.Shipment.MultiDuration;
import jmart.goldenSample.dbjson.Serializable;

public class Product extends Serializable
{
	public static final double COMMISSION_MULTIPLIER = 0.05;
    public static final double BOTTOM_PRICE          = 20000.0;
    public static final double BOTTOM_FEE            = 1000.0;
    
    public int storeId;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public double discount;
    public double price;
    public ProductCategory category;
    public MultiDuration multiDuration;
    
    public Product(int storeId, String name, int weight, boolean conditionUsed, double discount, double price, ProductCategory category, MultiDuration multiDuration)
    {
    	this.storeId = storeId;
    	this.name = name;
    	this.weight = weight;
    	this.conditionUsed = conditionUsed;
    	this.discount = discount;
    	this.price = price;
    	this.category = category;
    	this.multiDuration = multiDuration;
    }
    
    public double getAdjustedPrice()
    {
        return getDiscountedPrice() + getAdminFee();
    }

    public double getAdminFee()
    {
        double discountedPrice = getDiscountedPrice();
        if (discountedPrice < BOTTOM_PRICE)
            return BOTTOM_FEE;
        return COMMISSION_MULTIPLIER * discountedPrice;
    }

    private double getDiscountedPrice()
    {
        if (discount >= 100.0) return 0.0;
        double cut = price * discount / 100.0;
        return price - cut; 
    }
}
