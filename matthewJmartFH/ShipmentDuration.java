package matthewJmartFH;
import java.util.EnumSet;

/**
 * Write a description of class ShipmentDuration here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class ShipmentDuration
{
    public static  ShipmentDuration INSTANT  = new ShipmentDuration(00000001);
    public static  ShipmentDuration SAME_DAY = new ShipmentDuration(00000001);
    public static  ShipmentDuration NEXT_DAY = new ShipmentDuration(00000001);
    public static  ShipmentDuration REGULER  = new ShipmentDuration(00000001);
    public static  ShipmentDuration KARGO    = new ShipmentDuration(00000001);
    private  int bit;
    
    /**
     * Constructor for objects of class ShipmentDuration
     */
    private ShipmentDuration(int bit)
    {
        // initialise instance variables    
        this.bit = bit;
    }   
     
    public  ShipmentDuration(ShipmentDuration ...args)
    {   
        for(ShipmentDuration i :  args)
        {
            this.bit= this.bit|i.bit;
        }
            
        
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean isDuration(ShipmentDuration reference )
    {
        if((this.bit & (1 << (reference.bit -1))) > 0){
            return true;
        }
        else{
            return false;
        }
    }
}
