package modul3PTUT;

import com.Reflector.PackageRunner;

public class Source
{
    public static void main(String[] args)
    {
        PackageRunner runner = new PackageRunner("Modul 3 - PT");
        runner.setVisible(true);
        runner.add(new AccountTest());
        runner.add(new StoreTest());
        runner.add(new TransactorTest());
        runner.add(new ProductTest());
        runner.add(new PaymentTest());
        runner.add(new ShipmentTest());
        runner.add(new ComplaintTest());
        runner.add(new InvoiceTest());
        runner.run();
    }
}