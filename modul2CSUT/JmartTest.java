package modul2CSUT;

import com.Reflector.ClassR;
import com.Reflector.MonoPackageTester;
import com.Reflector.ReflectorModifier;
import com.Reflector.ReflectorUnitTest;

import java.lang.reflect.Method;
import unithelper.*;

public class JmartTest extends ReflectorUnitTest implements MonoPackageTester<JmartTest>
{
    ClassR Jmart;
    Method create;

    @Override
    protected void scenario()
    {
        assumeModifier(ReflectorModifier.PUBLIC, create);
        assumeModifier(ReflectorModifier.STATIC, create);

        assumeTrue(() -> {
            return create.getReturnType().getSimpleName().equals("Product");
        });

        assumeTrue(() -> {
            Object o = Jmart.getBypassInstantiation();
            Object prod = create.invoke(o);
            return prod.getClass().getSimpleName().equals("Product");
        });

    }

    @Override
    public JmartTest newInstance() {
        return new JmartTest();
    }

    @Override
    public void obtainPackage(String s) {
        Jmart = new ClassR(s, "Jmart");
        create = Jmart.getDeclaredMethod("create");
        Helper.setAccessible(create);
    }
}
