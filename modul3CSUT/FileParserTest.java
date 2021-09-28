package modul3CSUT;

import com.NetlabUT.*;
import com.Reflector.*;
import unithelper.Helper;

import java.lang.reflect.Method;

public class FileParserTest extends ReflectorUnitTest implements MonoPackageTester<FileParserTest>
{
    ClassR FileParser;
    Method read;
    Method write;
    Method newInstance;

    @Override
    protected void scenario() {
        assumeModifier(ReflectorModifier.PUBLIC, read);
        assumeModifier(ReflectorModifier.ABSTRACT, read);
        assumeModifier(ReflectorModifier.PUBLIC, write);
        assumeModifier(ReflectorModifier.DEFAULT, write);
        assumeModifier(ReflectorModifier.PUBLIC, newInstance);
        assumeModifier(ReflectorModifier.STATIC, newInstance);

        assumeEquals(boolean.class, () -> read.getReturnType());
        assumeEquals(Object.class, () -> write.getReturnType());
        assumeEquals(Object.class, () -> newInstance.getReturnType());
    }

    @Override
    public FileParserTest newInstance()
    {
        return new FileParserTest();
    }

    @Override
    public void obtainPackage(String s)
    {
        Helper.makeAccessible = true;
        FileParser = new ClassR(s, "FileParser");
        read = Helper.getDeclaredMethod(FileParser, "read", String.class);
        write = Helper.getDeclaredMethod(FileParser, "write");
        newInstance = Helper.getDeclaredMethod(FileParser, "newInstance", String.class);
    }
}
