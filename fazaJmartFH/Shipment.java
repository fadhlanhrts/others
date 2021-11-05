package fazaJmartFH;
import java.util.Date;
import java.util.Calendar;
import java.text.*;

public class Shipment
{
    public String address;
    public int shipmentCost;
    public Duration duration;
    public String receipt;
    
    public static class Duration
    {
        public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("E MMMM dd yyyy");
        public static final Duration INSTANT =  new Duration ((byte)(1<<0));
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
            Calendar tanggalBaru = Calendar.getInstance();
            
            switch(bit)
            {
                case (1<<0):
                case (1<<1):
                    return ESTIMATION_FORMAT.format(reference.getTime());
                case (1<<2):
                    tanggalBaru.setTime(reference);
                    tanggalBaru.add(Calendar.DATE, 1);
                    return ESTIMATION_FORMAT.format(reference.getTime());
                case (1<<3):
                    tanggalBaru.setTime(reference);
                    tanggalBaru.add(Calendar.DATE, 2);
                    return ESTIMATION_FORMAT.format(reference.getTime());
                default:
                    tanggalBaru.setTime(reference);
                    tanggalBaru.add(Calendar.DATE, 5);
                    return ESTIMATION_FORMAT.format(reference.getTime());    
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
            return (this.bit & reference.bit) == reference.bit;
        }
    }
    
    public Shipment(String address, int shipmentCost, Duration duration, String receipt)
    {
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
    }
}




