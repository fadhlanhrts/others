package modul1UT;

import com.Reflector.PackageRunner;

public class Source
{
    public static void main(String[] args)
    {
        PackageRunner runner = new PackageRunner("Modul 1 - CS");
        runner.setVisible(true);
        runner.add(new JmartTest());
    }
}