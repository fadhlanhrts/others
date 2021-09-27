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
        read = Helper.getDeclaredMethod(FileParser, "read");
        write = Helper.getDeclaredMethod(FileParser, "write");
        newInstance = Helper.getDeclaredMethod(FileParser, "newInstance");
    }
}
