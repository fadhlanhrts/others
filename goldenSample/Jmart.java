package goldenSample;

/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class Jmart
{
    private Jmart() {}
    
    public static void main (String[] args)
    {
    }
    
    public static int getPromo()
    {
        return 0;
    }
    
    public static String getCustomer()
    {
        return "oop";
    }
    
    /** nilai persentase diskon (penurunan harga dari {@code before} ke {@after}) */
    public static float getDiscountPercentage(int before, int after)
    {
        if (before < after || before == after) return 0.0f; 
        int cut = before - after;
        return 100.0f * cut / before;
    }

    /** nilai setelah diskon (setelah {@code price} dipotong dengan {@code discountPercentage}) */
    public static int getDiscountedPrice(int price, float discountPercentage)
    {
        if (discountPercentage >= 100.0f) return 0;
        float cut = price * discountPercentage / 100.0f;
        return price - (int) cut; 
    }

    /** harga asli sebelum dikenakan discount */
    public static int getOriginalPrice(int discountedPrice, float discountPercentage)
    {
        float divider = 100.0f - discountPercentage;
        return (int) (100 * discountedPrice / divider);
    }

    /** jmart mendapat komisi 5% untuk setiap barang yang diperjualkan */
    public static float getCommissionMultiplier()
    {
        return 0.05f;
    }

    /** harga yang disetel penjual ditambah biaya administrasi sesuai {@link Jmart#getCommissionMultiplier()} */
    public static int getAdjustedPrice(int price)
    {
        return price + getAdminFee(price);
    }

    /** biaya administrasi jmart sesuai dengan {@link Jmart#getCommissionMultiplier()} */
    public static int getAdminFee(int price)
    {
        return (int) (getCommissionMultiplier() * price);
    }
}