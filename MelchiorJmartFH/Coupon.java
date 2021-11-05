package MelchiorJmartFH;

public class Coupon extends Recognizable {
	public String name;
	public int code;
	public double cut;
	public Type type;
	public double minimum;
	private boolean used;

	public enum Type {
		DISCOUNT, REBATE
	}

	public Coupon(int id, String name, int code, Type type, double cut, double minimum) {
		this.name = name;
		this.code = code;
		this.cut = cut;
		this.type = type;
		this.minimum = minimum;
		used = false;
	}

	public boolean isUsed() {
		return this.used;
	}

	public boolean canApply(PriceTag priceTag) {
		if (priceTag.getAdjustedPrice() > this.minimum) {
			return true;
		} else {
			return false;
		}
	}

	public double Apply(PriceTag priceTag) {
		this.used = true;
		double temp = priceTag.getAdjustedPrice();
		double result;

		switch (type) {
		case DISCOUNT:
			System.out.println(priceTag.discount);
			break;
		case REBATE:
			System.out.println((temp * priceTag.discount) / 100);
			break;
		}

		result = temp - ((temp * priceTag.discount) / 100);
		return result;
	}

}
