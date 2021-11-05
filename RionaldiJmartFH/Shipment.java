package RionaldiJmartFH;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Write a description of class Shipment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shipment
{

    public String address;
    public int shipmentCost;
    public Duration duration;
    public String receipt;
    
    public Shipment(String address, int shipmentCost, Duration duration, String receipt) {
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
    }

    static class Plan{
        public final byte bit;

        private Plan(byte bit){
            this.bit = bit;
        }
    }

    
        static class Duration
        {

            
            public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("EEE MMMM dd yyyy");
            public static final Duration INSTANT = new Duration((byte)00000001);
            public static final Duration SAME_DAY = new Duration((byte)00000010);
            public static final Duration NEXT_DAY = new Duration((byte)00000100);
            public static final Duration REGULER = new Duration((byte)00001000);
            public static final Duration KARGO = new Duration((byte)00010000) ;
            public byte bit;
            
            private Duration(byte bit){
                this.bit = bit;
            }
            
            public String getEstimatedArrival(Date reference){
                Calendar cal = Calendar.getInstance();
                cal.setTime(reference);
                if (this.bit == INSTANT.bit || this.bit == SAME_DAY.bit){
                    return ESTIMATION_FORMAT.format(cal);
                } else if (this.bit == NEXT_DAY.bit){
                    cal.add(Calendar.DATE, 1);
                    return ESTIMATION_FORMAT.format(cal);
                } else if (this.bit == REGULER.bit){
                    cal.add(Calendar.DATE, 2);
                    return ESTIMATION_FORMAT.format(cal);
                } else {
                    cal.add(Calendar.DATE, 5);
                    return ESTIMATION_FORMAT.format(cal);
                } 
                
            }

        }
        
         class MultiDuration{
            public byte bit;
            
            public MultiDuration(Duration... args){
               for (Duration i: args){
                   this.bit = (byte)(this.bit | i.bit);
               }
            }
            
            public boolean isDuration(Duration reference){
                if((this.bit & (1 << (reference.bit - 1))) > 0){
                    return true;
                } else{
                    return false;
                }
                
        }
            
        }

}

