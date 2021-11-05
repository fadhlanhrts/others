package AidanAzkafaroDesonJmartFH;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;


/**
 * Write a description of class Shipment here.
 *
 * @author (Aidan Azkafaro Deson)
 * @version (a version number or a date)
 */
public class Shipment 
{
    // instance variables - replace the example below with your own
    public String address;
    public int shipmentCost;
    public Duration duration;
    public String receipt;
    
    public Shipment(String address, int shipmentCost, Duration duration, String receipt){
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
    }
    
    public static class Duration
    {
        // instance variables - replace the example below with your own
        public static final Duration INSTANT = new Duration((byte)(1 << 0));
        public static final Duration SAME_DAY = new Duration((byte)(1 << 1));
        public static final Duration NEXT_DAY = new Duration((byte)(1 << 2));
        public static final Duration REGULER = new Duration((byte)(1 << 3));
        public static final Duration KARGO = new Duration((byte)(1 << 4));
        private byte bit;
        
        public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("'Date Format'E MMMM dd yyyy");
    
        
        private Duration(byte bit)
        {
            this.bit = bit;
            
        }
        
        public String getEstimatedArrival(Date reference){
            Calendar cal = Calendar.getInstance();
            
            if (this.bit == 1<<0|| this.bit == 1<<1)
            {
                return ESTIMATION_FORMAT.format(reference.getTime());
            } else if(this.bit == 1<<2)
            {
                cal.setTime(reference);
                cal.add(Calendar.DATE,1);
                return ESTIMATION_FORMAT.format(cal);
            } else if(this.bit == 1<<3)
            {
                cal.setTime(reference);
                cal.add(Calendar.DATE,2);
                return ESTIMATION_FORMAT.format(cal);
            } else
            {
                cal.setTime(reference);
                cal.add(Calendar.DATE,5);
                return ESTIMATION_FORMAT.format(cal);
            }
            
        }
    }
    
    public static class MultiDuration{
        
        private byte bit;
        
        public MultiDuration(byte... args){
            
            for(byte s:args)
            {
                this.bit = (byte)(this.bit|s);

            }
        }
        
        public boolean isDuration(Duration reference){
            if ((reference.bit & this.bit) != 0){
                return true;
            }
            
            return false;
            
        }
        
    }
    
    public boolean read (String content){
        return false;
    };
    
}