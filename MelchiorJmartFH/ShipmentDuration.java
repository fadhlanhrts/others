package MelchiorJmartFH;


public class ShipmentDuration
{
    
    public static final ShipmentDuration INSTANT = new ShipmentDuration(1 << 0);
    public static final ShipmentDuration SAME_DAY = new ShipmentDuration(1 << 1);
    public static final ShipmentDuration NEXT_DAY = new ShipmentDuration(1 << 2);
    public static final ShipmentDuration REGULER = new ShipmentDuration(1 << 3);
    public static final ShipmentDuration KARGO = new ShipmentDuration(1 << 4);
    private int bit;
    
    private ShipmentDuration(int bit){
        this.bit = bit;
    }
    
    public ShipmentDuration(int... inputBit){
        for(int i : inputBit){
            this.bit = this.bit | i;
        }
    }
    
    public boolean isDuration(ShipmentDuration reference){
        if((reference.bit & this.bit) != 0){
            return true;
        }
        return false;
    }
}
