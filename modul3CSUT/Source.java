package modul3CSUT;

import com.Reflector.PackageRunner;

public class Source
{
    public static void main(String[] args)
    {
        PackageRunner runner = new PackageRunner("Modul 3 - CS");
        runner.setVisible(true);
        runner.add(new AccountTest());
        runner.run();
    }
}