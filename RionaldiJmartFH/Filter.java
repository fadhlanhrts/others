package RionaldiJmartFH;
import java.util.ArrayList;


/**
 * Write a description of class Filter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Filter
{
    
    public static ArrayList<PriceTag> filterPriceTag(PriceTag[] list, double value, boolean less){
        ArrayList<PriceTag> arr = new ArrayList<PriceTag>();
        if (less == true){
            for(PriceTag pricetag : list){
                if (pricetag.getAdjustedPrice() < value){
                    arr.add(pricetag);
                }
            }
        } else {
            for(PriceTag pricetag : list){
                if (pricetag.getAdjustedPrice() >= value){
                    arr.add(pricetag);
                }
            }
        }
        return arr;
    }
    
    public static void filterProductRating(ArrayList<ProductRating> list, double value, boolean less){

        if (less == true){
            for(ProductRating product : list){
                if (product.getAverage() < value){
                    list.remove(product);
                }
            }
        } else {
            for(ProductRating product : list){
                if (product.getAverage() >= value){
                    list.remove(product);
                }
            }
        }

    }
    
}
