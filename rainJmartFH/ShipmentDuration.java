package rainJmartFH;


/**
 * Write a description of class ShipDuration here.
 *
 * @author rain
 * @version (a version number or a date)
 */
public class ShipmentDuration
{
    // instance variables - replace the example below with your own
    public ShipmentDuration INSTANT;
    public ShipmentDuration SAME_DAY;
    public ShipmentDuration NEXT_DAY;
    public ShipmentDuration REGULER;
    public ShipmentDuration KARGO;
    private int bit;

    /**
     * Constructor for objects of class ShipDuration
     */
    private ShipmentDuration(int bit)
    {
        this.bit = bit;
    }
    
    public ShipmentDuration(ShipmentDuration... args){
        int bit;
    }
    
    public boolean isDuration(ShipmentDuration reference){
        return false;
    }
    
    
}
