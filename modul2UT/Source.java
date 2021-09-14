package modul2UT;

import com.Reflector.PackageRunner;

public class Source
{
    public static void main(String[] args)
    {
        PackageRunner runner = new PackageRunner("Modul 2 - CS");
        runner.add(new ItemCategoryTest());
        runner.add(new PriceTagTest());
        runner.add(new ProductRatingTest());
        runner.add(new ProductTest());
        runner.setVisible(true);
        runner.run();
    }
}
