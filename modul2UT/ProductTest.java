package modul2UT;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import com.Reflector.*;
import com.NetlabUT.*;

public class ProductTest extends ReflectorUnitTest implements MonoPackageTester<ProductTest> 
{
    @Override
    public ProductTest newInstance() {
        return new ProductTest();
    }

    @Override
    public void obtainPackage(String arg0) {
    }

    @Override
    protected void scenario() {
    }
    
}
