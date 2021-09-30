package goldenSample;

import java.util.Calendar;
import java.util.Date;

public class Shipment implements FileParser {
    public static class Duration {
        public static final Duration INSTANT = new Duration((byte) (1 << 0));
        public static final Duration SAME_DAY = new Duration((byte) (1 << 1));
        public static final Duration NEXT_DAY = new Duration((byte) (1 << 2));
        public static final Duration REGULER = new Duration((byte) (1 << 3));
        public static final Duration KARGO = new Duration((byte) (1 << 4));

        public final byte bit;

        private Duration(byte bit) {
            this.bit = bit;
        }
    }

    public static class MultiDuration {
        public final byte bit;

        public MultiDuration(Duration... args) {
            byte flags = 0;
            for (byte i = 0; i < args.length; ++i)
                flags |= args[i].bit;
            bit = flags;
        }

        public boolean isDuration(Duration reference) {
            return (bit & reference.bit) != 0;
        }
    }

    public String address;
    public int shipmentCost;
    public Duration duration;
    public String receipt;
    public Date purchaseDate;
    public Date deliveredDate;

    public Shipment(String address, int shipmentCost, Duration duration, String receipt, Date purchaseDate) {
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
        this.purchaseDate = purchaseDate;
        setDeliveredDate();
    }

    @Override
    public boolean read(String content) {
        // TODO Auto-generated method stub
        return false;
    }

    public void setDeliveredDate() {
        deliveredDate = purchaseDate;
        Calendar cal = Calendar.getInstance();
        cal.setTime(deliveredDate);
        if (duration.bit == Duration.NEXT_DAY.bit) {
            cal.add(Calendar.DATE, 1);
        } else if (duration.bit == Duration.REGULER.bit) {
            cal.add(Calendar.DATE, 2);
        } else if (duration.bit == Duration.KARGO.bit) {
            cal.add(Calendar.DATE, 5);
        } else {
            deliveredDate = purchaseDate;
        }
        deliveredDate = cal.getTime();
    }
}
