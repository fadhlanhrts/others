package AidanAzkafaroDesonJmartFH;


public class ShipmentDuration
{
    // instance variables - replace the example below with your own
    public static final ShipmentDuration INSTANT = new ShipmentDuration(1 << 0);
    public static final ShipmentDuration SAME_DAY = new ShipmentDuration(1 << 1);
    public static final ShipmentDuration NEXT_DAY = new ShipmentDuration(1 << 2);
    public static final ShipmentDuration REGULER = new ShipmentDuration(1 << 3);
    public static final ShipmentDuration KARGO = new ShipmentDuration(1 << 4);
    private final int bit;
    
    private ShipmentDuration(int bit)
    {
        this.bit = bit;
    }
    
    public ShipmentDuration (ShipmentDuration... args)
    {
        int tempBit = 0;
        for(ShipmentDuration s:args)
        {
            tempBit = tempBit | s.bit; 
        }
        
        this.bit = tempBit;
        
    }
    
    public boolean isDuration(ShipmentDuration reference)
    {
        int tempBit = this.bit;
        if((reference.bit & tempBit) == reference.bit)
        {
            return true;
        }

        return false;
    }
    
 
    
}
