package modul3PTUT;

import com.Reflector.ClassR;
import com.Reflector.MonoPackageTester;
import com.Reflector.ReflectorModifier;
import com.Reflector.ReflectorUnitTest;
import unithelper.Helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StoreTest extends ReflectorUnitTest implements MonoPackageTester<StoreTest>
{
    ClassR Store;
    Constructor<?> ctor;
    Method toString;

    @Override
    protected void scenario() {
        assumeModifier(ReflectorModifier.PUBLIC, toString);
        assumeEquals(String.class, () -> toString.getReturnType());
        assumeTrue(() -> {
            Object obj = ctor.newInstance(0, "Jono", "papua", "0123");
            String str = (String) toString.invoke(obj);
            return str.contains("Jono") && str.contains("papua") && str.contains("0123");
        });
    }

    @Override
    public StoreTest newInstance() {
        return new StoreTest();
    }

    @Override
    public void obtainPackage(String s) {
        Helper.makeAccessible = true;
        Store = new ClassR(s, "Account");
        ctor = Helper.getDeclaredConstructor(Store, int.class, String.class, String.class, String.class);
        toString = Helper.getDeclaredMethod(Store, "toString");
    }
}