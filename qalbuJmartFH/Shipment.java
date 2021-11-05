package qalbuJmartFH;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Shipment implements FileParser {
    public String address;
    public int shipmentCost;
    public Duration duration;
    public String receipt;
    
    public Shipment ( String address, int shipmentCost, Duration duration,
    String receipt){
        
    }
    
    public static class Duration {
        Date reference = new Date();
        SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat
        ("EEE MMM dd yyyy");
        public enum ShipmentDuration {
            INSTANT , SAME_DAY, NEXT_DAY, REGULER, KARGO;
        }
        public byte bit () {
         return 0;
        }
        
        private Duration (byte bit) {
            
        }
        
        public String getEstimatedArrival (Date reference) {
            /*switch (ShipmentDuration) {
                case INSTAN:
                    return reference;
                case SAME_DAY : 
                    return reference;*/
                return null;
            }
        }
    
    
     class MultiDuration {
    public byte bit () {
    return 0;
     }
        
        public void MultiDuration (Duration[] args) {
        
    }
    
    public boolean isDuration (Duration reference) {
        if (reference == null) {
            return true;
        }
        
        if (reference == null) {
            return false;
        }
        
        if (reference == null) {
            return true;
        }
        
        if (reference == null) {
            return false;
        }
        
        if (reference == null) {
            return false;
        }
      return true;  
    }
    }
    
    public boolean read (String content){
        return false;
    }
    public Object write (){
        return null;
    }
    public Object newInstance (String content){
        return null;
    }
}