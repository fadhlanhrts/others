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

    public static Product create()
    {
        return new Product("Item", 0, false, new PriceTag(100.0), ProductCategory.BOOK);
    }
}