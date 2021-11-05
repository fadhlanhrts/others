package fazaJmartFH;
import java.util.ArrayList;

public class Filter
{
    public static ArrayList<PriceTag> filterPriceTag(PriceTag[] list, int value, boolean less)
    {
        ArrayList<PriceTag> filter = new ArrayList<PriceTag>();
        
        if(less == true)
        {
            for(int i = 0; i < list.length; ++i)
            {
                if(list[i].getAdjustedPrice() < value)
                {
                    filter.add(list[i]);
                }
            }
        }
        else
        {
            for(int i = 0; i < list.length; ++i)
            {
                if(list[i].getAdjustedPrice() >= value)
                {
                    filter.add(list[i]);
                }
            }
        }
        return filter;
    }
       
    public static void filterProductRating(ArrayList<ProductRating> list, double value, boolean less)
    {
        if(less == true)
        {
            for(int i = 0; i < list.size(); ++i)
            {
                if(list.get(i).getAverage() < value)
                {
                    list.remove(i);
                }
            }
        }
        else
        {
            for(int i = 0; i < list.size(); ++i)
            {
                if(list.get(i).getAverage() >= value)
                {
                    list.remove(i);
                }
            }
        }
    }
}
