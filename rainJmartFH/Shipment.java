package rainJmartFH;


/**
 * Write a description of class Shipment here.
 *
 * @author rain
 * @version (a version number or a date)
 */
public class Shipment
{
    
    
    public String address;
    public int shipmentCost;
    public Duration duration;
    public String receipt;

    
    public Shipment(String address, int shipmentCost, Duration duration, String receipt)
    {

    }
    
    
    public class Duration
    {
        // instance variables - replace the example below with your own
        public Duration INSTANT;
        public Duration SAME_DAY;
        public Duration NEXT_DAY;
        public Duration REGULER;
        public Duration KARGO;
        private byte bit;

    
        private Duration(byte bit)
        {
            this.bit = bit;
        }
    
        public Duration(Duration... args){
            int bit;
        }
    
        public boolean isDuration(Duration reference){
            return false;
        }
    
    
    }
    
    
    public class MultiDuration
    {
        byte bit;
        
        public MultiDuration(Duration[] durations){

        }
        
        public boolean isDuration(Duration duration){
            return false;
        }
    }
}


