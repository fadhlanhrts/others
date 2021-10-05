package jmart.goldenSample.dataset;

public class Shipment
{
    public static class Duration
    {
        public static final Duration INSTANT  = new Duration((byte) (1 << 0));
        public static final Duration SAME_DAY = new Duration((byte) (1 << 1));
        public static final Duration NEXT_DAY = new Duration((byte) (1 << 2));
        public static final Duration REGULER  = new Duration((byte) (1 << 3));
        public static final Duration KARGO    = new Duration((byte) (1 << 4));

        public final byte bit;
        private Duration(byte bit) { this.bit = bit; }
    }

    public class MultiDuration
    {
        public final byte bit;
        public MultiDuration(Duration... args) 
        {
            byte flags = 0;
            for (byte i = 0; i < args.length; ++i)
            flags |= args[i].bit;
            bit = flags;
        }
        public boolean isDuration(Duration reference) { return (bit & reference.bit) != 0; }
    }

    public String address;
    public int shipmentCost;
    public byte duration;
    public String receipt;

    public Shipment(String address, int shipmentCost, Duration duration, String receipt)
    {
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration.bit;
        this.receipt = receipt;
    }
}
