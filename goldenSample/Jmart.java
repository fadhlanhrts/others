package goldenSample;

/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jmart
{
    private Jmart()
    {
        
    }
    
    public static void main (String[] args)
    {
        float res = getDiscount(10000, 8000);
    }
    
    public static int getPromo()
    {
        return 0;
    }
    
    public static String getCustomer()
    {
        return "oop";
    }
    
    public static float getDiscount(int before, int after)
    {
        int cut = before - after;
        return cut / before * 100;
    }
}
