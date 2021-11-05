package matthewJmartFH;
import java.util.ArrayList;


/**
 * Write a description of class Filter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Filter
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Filter
     */
    public Filter()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static  ArrayList<PriceTag> filterPriceTag(PriceTag[] list,int value, boolean less)
    {
         ArrayList<PriceTag> pt_arr = new ArrayList<PriceTag>();
         if(less == true)
         {
             for(PriceTag i : pt_arr)
             {
                 if (i.getAdjustedPrice() < value)
                 {
                     pt_arr.add(i);
                 }
             }
         }
         
         else
         {
             for(PriceTag i : pt_arr)
             {
                 if (i.getAdjustedPrice() >= value)
                 {
                     pt_arr.add(i);
                 }
             }
         }
        
         return pt_arr;
    }
    
    public static void filterProductRating(ArrayList<ProductRating> list, double value, boolean less)
    {
        ArrayList<ProductRating> pr_arr = new ArrayList<ProductRating>();
         if(less == true)
         {
             for(ProductRating i : pr_arr)
             {
                 if (i.getAverage() < value)
                 {
                     pr_arr.remove(i);
                 }
             }
         }
         
         else
         {
             for(ProductRating i : pr_arr)
             {
                 if (i.getAverage() >= value)
                 {
                     pr_arr.add(i);
                 }
             }
         }
        
         
    }
}
