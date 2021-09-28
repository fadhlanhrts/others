package modul3CSUT;

import com.Reflector.PackageRunner;

public class Source
{
    public static void main(String[] args)
    {
        PackageRunner runner = new PackageRunner("Modul 3 - CS");
        runner.setVisible(true);
        runner.add(new AccountTest());
        runner.add(new StoreTest());
        runner.add(new ComplainTest());
        runner.add(new FileParserTest());
        runner.add(new PaymentTest());
        runner.add(new TransactionTest());
        runner.add(new RecognizableTest());
        runner.add(new ProductTest());
        runner.add(new CouponTest());
        runner.run();
    }
}