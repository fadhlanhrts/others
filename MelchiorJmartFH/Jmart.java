package MelchiorJmartFH;

public class Jmart {
	public static void main(String[] args) {
		System.out.print("Hello from Eclipse");
	}

	public static Product create() {
		// Product myProduct = new Product();
		String name = "Handphone";
		int weight = 35;
		boolean condition = true;
		// PriceTag price = new PriceTag();
		ProductCategory category = ProductCategory.ELECTRONIC;
		return null;
	}

	public Product createProduct() {
		return null;
	}

	public Coupon createCoupon() {
		return null;
	}

	public ShipmentDuration createShipmentDuration() {
		return null;
	}

	static int getPromo() {
		return 0;
	}

	static String getCustomer() {
		String txt = "oop";
		return txt;
	}

	static float getDiscountPercentage(int price, int discountPercentage) {
		float temp = price;
		if (discountPercentage > 100) {
			return 0;
		} else {
			temp -= (discountPercentage * temp);
			return temp;
		}
	}

	static float getOriginalPrice(int discountedPrice, float discountPercentage) {
		float result;

		result = ((100 / (100 - discountPercentage)) * discountedPrice);
		return result;
	}

	static float getCommisionMultiplier() {
		float Com = 5 / 100;
		return Com;
	}

	static int getAdjustedPrice(int price) {
		int result;
		result = price + ((5 / 100) * price);
		return result;
	}

	static int getAdminFee(int price) {
		int temp = (int) getCommisionMultiplier();
		int result;
		result = temp * price;
		return result;
	}
}
