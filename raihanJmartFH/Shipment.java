package RaihanJmartFH;
import java.util.Calendar;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Shipment implements FileParser
{
    public String address, receipt;
    public int shipmentCost;
    public Duration duration;
    
    Shipment(String address, int shipmentCost, Duration duration, String receipt){
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
    };
    
    public static class Duration{
        public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("EEE MMMM dd yyyy");
        public static final Duration INSTANT  = new Duration((byte)(1 << 0));
        public static final Duration SAME_DAY = new Duration((byte)(1 << 1));
        public static final Duration NEXT_DAY = new Duration((byte)(1 << 2));
        public static final Duration REGULER  = new Duration((byte)(1 << 3));
        public static final Duration KARGO    = new Duration((byte)(1 << 4));
    
        private final byte bit;
    
        private Duration(byte bit){ 
            this.bit = bit; }
            
        public Duration(Duration... args){
            byte flags = 0;
            for (byte i = 0; i < args.length; ++i)
                flags |= args[i].bit;
            bit = flags;
        }
        
        public boolean isDuration(Duration reference){
            return (bit & reference.bit) != 0; 
        }
        
        public String getEstimatedArrival(Date reference){
                if (this.bit == 1 << 0 || this.bit == SAME_DAY.bit){
                    return ESTIMATION_FORMAT.format(reference);
                }
                else if(this.bit == 1 << 2){
                    return ESTIMATION_FORMAT.format(reference.getDay() + 1 );
                }
                else if(this.bit == 1 << 3){
                    return ESTIMATION_FORMAT.format(reference.getDay() + 2 );
                }
                else{
                    return ESTIMATION_FORMAT.format(reference.getDay() + 5 );
                }
            }
}

public class MultiDuration{
    public byte bit;
    
    public MultiDuration(Duration... args){
        byte total = 0;
        for (Duration i: args){
            total |= i.bit;
        }
        this.bit = total;        
   }

    public boolean isDuration(Duration reference){
        if ((bit & reference.bit) != 0){
            return true;
        }
        else{
            return false;
        }
    }
}

    @Override
        public boolean read(String content){
            return false;
        }
}