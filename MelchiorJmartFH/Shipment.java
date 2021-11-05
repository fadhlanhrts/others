package MelchiorJmartFH;

import java.util.Calendar;
import java.text.*;
import java.util.Date;

public class Shipment {
	public String address, receipt;
	public int shipmentCost;
	public Duration duration;

	public static class Duration {
		public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("EEE MMMM dd yyyy");
		public static final Duration INSTANT = new Duration((byte) (1 << 0));
		public static final Duration SAME_DAY = new Duration((byte) (1 << 1));
		public static final Duration NEXT_DAY = new Duration((byte) (1 << 2));
		public static final Duration REGULER = new Duration((byte) (1 << 3));
		public static final Duration KARGO = new Duration((byte) (1 << 4));
		private byte bit;

		private Duration(byte bit) {
			this.bit = bit;
		}

		public String getEstimatedArrival(Date reference) {
			Calendar cal = Calendar.getInstance();
			if (bit == 1 << 0 || bit == 1 << 1) {
				return ESTIMATION_FORMAT.format(reference.getTime());
			} else if (bit == 1 << 2) {
				cal.setTime(reference);
				cal.add(Calendar.DATE, 1);
				return ESTIMATION_FORMAT.format(cal);
			} else if (bit == 1 << 3) {
				cal.setTime(reference);
				cal.add(Calendar.DATE, 2);
				return ESTIMATION_FORMAT.format(cal);
			} else {
				cal.setTime(reference);
				cal.add(Calendar.DATE, 5);
				return ESTIMATION_FORMAT.format(cal);
			}
		}
	}

	public class MultiDuration {
		public byte bit;

		public MultiDuration(byte... args) {
			for (byte i : args) {
				this.bit = (byte) (this.bit | i);
			}
		}

		public boolean isDuration(Duration reference) {
			if ((reference.bit & this.bit) != 0) {
				return true;
			}
			return false;
		}
	}

}
