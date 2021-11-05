package matthewJmartFH;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
/**
 * Write a description of class Shipment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shipment implements FileParser
{
    // instance variables - replace the example below with your own
    public String address;
    public int shipmentCost;
    public  Duration duration;
    public String receipt;
    public Shipment(String address, int shipmentCost, Duration duration, String receipt)
    {
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
    }
    

    
    static class Duration
{
    public static final Duration INSTANT  = new Duration((byte)00000001);
    public static final Duration SAME_DAY = new Duration((byte)00000010);
    public static final Duration NEXT_DAY = new Duration((byte)00000100);
    public static final Duration REGULER  = new Duration((byte)00001000);
    public static final Duration KARGO    = new Duration((byte)00010000);
    public  byte bit;
    public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("EEE MMMM dd yyyy");
    
    private  Duration(byte bit)
    {
         
        this.bit = bit;
    }   
    
    public String getEstimatedArrival(Date reference)
    
    {   Calendar cal =  Calendar.getInstance();
        cal.setTime(reference);
        if(this.bit == INSTANT.bit || this.bit == SAME_DAY.bit)
        {
            return ESTIMATION_FORMAT.format(cal);
        }
        
        else if(this.bit == NEXT_DAY.bit )
        {   
            cal.add(Calendar.DATE, +1);
            return ESTIMATION_FORMAT.format(cal);
        }
        
        else if(this.bit == REGULER.bit )
        {   
            cal.add(Calendar.DATE, +2);
            return ESTIMATION_FORMAT.format(cal);
        }
         else
        {   
            cal.add(Calendar.DATE, +5);
            return ESTIMATION_FORMAT.format(cal);
        }
        
    }
}
    public boolean read(String content)
    {
        return false;
    }
    class MultiDuration {
        public byte bit;
        
        public MultiDuration(Duration... args) 
        {
        
            for (Duration md : args) {
                this.bit = (byte) (this.bit | md.bit);    
            }
        }
        
        public boolean isDuration(Duration duration) {
            if ((this.bit & (1 << (duration.bit - 1))) >= 0) 
            {
                return true;
            }
            return false;
        }
    }
}
