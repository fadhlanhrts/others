package modul4CSUT;

import com.Reflector.ClassR;
import com.Reflector.MonoPackageTester;
import com.Reflector.ReflectorModifier;
import unithelper.ExtendedRUT;
import unithelper.Helper;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Date;
import java.lang.reflect.Method;

public class StoreTest extends ExtendedRUT implements MonoPackageTester<StoreTest> {
    ClassR Store;
    Constructor<?> ctor;
    Field date;
    Method validate;

    @Override
    public StoreTest newInstance() {
        return new StoreTest();
    }

    @Override
    public void obtainPackage(String s) {
        Helper.makeAccessible = true;
        Store = new ClassR(s, "Store");
        ctor = Helper.getDeclaredConstructor(Store, int.class, String.class, String.class, String.class);
        date = Helper.getDeclaredField(Store, "date");
        validate = Helper.getDeclaredMethod(Store, "validate");
    }

    @Override
    protected void scenario() {
        assumeModifier(ReflectorModifier.PUBLIC, validate);
        assumeEquals(boolean.class, () -> validate.getReturnType());
        assumeTrue(() -> {
            Object obj = ctor.newInstance(0, "MARTIN", "jakarta pusat", "111111111111");
            boolean val = (boolean) validate.invoke(obj);
            return val;
        });
        assumeFalse(() -> {
            Object obj = ctor.newInstance(0, "mar", "jakarta pusat", "123132");
            boolean val = (boolean) validate.invoke(obj);
            return val;
        });

    }

}
