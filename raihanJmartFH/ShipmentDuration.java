package raihanJmartFH;

public class ShipmentDuration
{
    // instance variables - replace the example below with your own
    public static final ShipmentDuration INSTANT = new ShipmentDuration(1<<0);
    public static final ShipmentDuration SAME_DAY = new ShipmentDuration(1<<1);
    public static final ShipmentDuration NEXT_DAY = new ShipmentDuration(1<<2);
    public static final ShipmentDuration REGULER = new ShipmentDuration(1<<3);
    public static final ShipmentDuration KARGO = new ShipmentDuration(1<<4);
    private int bit;

    public ShipmentDuration(int bit)
    {
        this.bit = bit;
    }
    
    public ShipmentDuration(ShipmentDuration... args){
       for(ShipmentDuration i : args){
           bit = bit | i.bit;
       }
    }
    
    public boolean isDuration(ShipmentDuration reference){
        if(reference == null){
            return true;
        }
        else{
            return (this.bit & reference.bit) != 0;
        }
    }
}
