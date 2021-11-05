package valentinusJmartFH;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Shipment implements FileParser
{
    public String address;
    public int shipmentCost;
    public Duration duration;
    public String receipt;
    
    public static class Duration
    {
        public static SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("E, MM/dd/yyyy");
        public static final  Duration INSTANT =  new Duration ((byte)(1<<0));
        public static final Duration SAME_DAY =  new Duration ((byte)(1<<1));
        public static final Duration NEXT_DAY = new Duration ((byte)(1<<2));
        public static final Duration REGULER = new Duration ((byte)(1<<3));
        public static final Duration KARGO = new Duration ((byte)(1<<4));
        public byte bit;
        
        private Duration(byte bit)
        {
            this.bit = bit;
        }
        
        public String getEstimatedArrival(Date reference) 
        {
            Calendar tanggal = Calendar.getInstance();
            
            if(this.bit == 1<<0|| this.bit == 1<<1)
            {
                return ESTIMATION_FORMAT.format(reference.getTime());
            }
            
            else if(this.bit == 1<<2)
            {
                tanggal.setTime(reference);
                tanggal.add(Calendar.DATE,1);
                return ESTIMATION_FORMAT.format(tanggal);
            }
            
            else if(this.bit == 1<<3)
            {
                tanggal.setTime(reference);
                tanggal.add(Calendar.DATE,2);
                return ESTIMATION_FORMAT.format(tanggal);
            }
            
            else
            {
                tanggal.setTime(reference);
                tanggal.add(Calendar.DATE,5);
                return ESTIMATION_FORMAT.format(tanggal);
            }
        }
    }
    
    public class MultiDuration
    {
        public byte bit;
        
        public MultiDuration(Duration... args)
        {
            for(Duration i: args)
            {
                this.bit |= i.bit;
            }
        }
        
        public boolean isDuration(Duration reference)
        {
            if((this.bit & reference.bit) == reference.bit)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
    
    public Shipment(String address, int shipmentCost, Duration duration, String receipt)
    {
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
    }
    
    public boolean read (String content)
    {
        return false;
    }
}