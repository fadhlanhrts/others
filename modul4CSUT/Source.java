package modul4CSUT;

import com.Reflector.PackageRunner;

public class Source {
    public static void main(String[] args) {
        PackageRunner runner = new PackageRunner("Modul 4 - CS");
        runner.setVisible(true);
        runner.add(new InvoiceTest());
        runner.add(new ComplaintTest());
        runner.add(new StoreTest());
        runner.add(new ShipmentTest());
        runner.add(new FilterTest());
        runner.run();
    }
}