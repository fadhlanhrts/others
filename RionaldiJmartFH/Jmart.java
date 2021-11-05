package RionaldiJmartFH;
import java.io.*;

/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jmart
{
    public static int getPromo(){
        return 0;
    }
    
    public static String getCustomer(){
        return "oop";
    }
    
    public static float getDiscountPercentage(int before, int after){
        float discountPercentage = 0.0f;
        if (before <= after){
            return discountPercentage;
        } 
        return discountPercentage = (((before - after)*100)/before);
    }
    
    public static int getDiscountedPrice(int price, float discountPercentage){
        float discountedPrice = 0;
        if (discountPercentage >= 100){
            price = 0;
        }
        float discount = discountPercentage/100;
        discountedPrice = price - price * discount;
        return (int)discountedPrice;
    }
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage){
        float originalPrice = discountedPrice/(1-(discountPercentage/100));
        return (int)originalPrice;
    }
    
    public static float getCommissionMultiplier(){
        return 0.05f;
    }
    
    public static int getAdjustedPrice(int price){
        float x = getCommissionMultiplier() * price;
        return price + (int)x ;
    }
    
    
    public static int getAdminFee(int price){
        float y = getCommissionMultiplier() * price;
        return (int)y;
    }    
    
    
    public static void main(String[] args){

    }
    
    
    
    
    
    
}
