package AidanAzkafaroDesonJmartFH;
import java.util.ArrayList;


/**
 * Write a description of class Filter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Filter
{
   public static ArrayList<PriceTag> filterPriceTag(PriceTag[] list, double value, boolean less) 
    {
        ArrayList<PriceTag> priceTag = new ArrayList<>();
        for (PriceTag s : list) {
            if (less && s.getAdjustedPrice() < value || !less && s.getAdjustedPrice() >= value)
            {
                priceTag.add(s);
            }
        }
        
        return priceTag;
   }
    
   public static void filterProductRating(ArrayList<ProductRating> list, double value, boolean less) 
    {
        
        for (int i = 0; i < list.size(); ++i) 
        {
            final ProductRating e = list.get(i);
            if (less && e.getAverage() < value || !less && e.getAverage() >= value)
            {
                list.remove(i);
            }
        }
        
    }
}
