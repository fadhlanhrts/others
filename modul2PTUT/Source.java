package modul2PTUT;

import com.Reflector.PackageRunner;

public class Source
{
    public static void main(String[] args)
    {
        PackageRunner runner = new PackageRunner("Modul 2 - PT");
        runner.add(new JmartTest());
        runner.add(new ShipmentDurationTest());
        runner.add(new CouponTest());
        runner.setVisible(true);
        runner.run();
    }
}