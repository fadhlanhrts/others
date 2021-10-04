package modul4PTUT;

import com.Reflector.PackageRunner;

public class Source {
    public static void main(String[] args) {
        PackageRunner runner = new PackageRunner("Modul 4 - PT");
        runner.setVisible(true);
        runner.add(new AccountTest());
        runner.add(new ComplaintTest());
        runner.add(new InvoiceTest());
        runner.run();
    }
}