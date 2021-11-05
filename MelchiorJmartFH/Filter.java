package MelchiorJmartFH;

import java.util.ArrayList;

public class Filter {
	public static void filterProductRating(ArrayList<ProductRating> list, double value, boolean less) {

		for (int i = 0; i < list.size(); ++i) {
			final ProductRating a = list.get(i);
			if (less && a.getAverage() < value || !less && a.getAverage() >= value) {
				list.remove(i);
			}
		}

	}

	public static ArrayList<PriceTag> filterPriceTag(PriceTag[] list, int value, boolean less) {
		ArrayList<PriceTag> arrList = new ArrayList<PriceTag>();

		for (PriceTag i : list) {
			if (less && i.getAdjustedPrice() < value || !less && i.getAdjustedPrice() >= value) {
				arrList.add(i);
			}
		}

		return arrList;
	}
}
