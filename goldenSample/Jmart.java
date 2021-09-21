package goldenSample;

/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class Jmart
{
    public static void main (String[] args)
    {
    }

    public static Product createProduct()
    {
        return new Product("Item", 0, false, new PriceTag(100.0), ProductCategory.BOOK);
    }

    public static Coupon createCoupon()
    {
        return new Coupon("My Coupon", 21312, Coupon.Type.REBATE, 10000, 50000);
    }

    public static ShipmentDuration createShipmentDuration()
    {
        return new ShipmentDuration(ShipmentDuration.INSTANT, ShipmentDuration.KARGO);
    }
}