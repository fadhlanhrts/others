package modul3PTUT;

import com.Reflector.ClassR;
import com.Reflector.MonoPackageTester;
import com.Reflector.ReflectorModifier;
import com.Reflector.ReflectorUnitTest;
import unithelper.Helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AccountTest extends ReflectorUnitTest implements MonoPackageTester<AccountTest>
{
    ClassR Account;
    Constructor<?> ctor;
    Method toString;

    @Override
    protected void scenario() {
        assumeModifier(ReflectorModifier.PUBLIC, toString);
        assumeEquals(String.class, () -> toString.getReturnType());
        assumeTrue(() -> {
            Object obj = ctor.newInstance(0, "Jono", "jono@ui.ac.id", "jono123");
            String str = (String) toString.invoke(obj);
            return str.contains("Jono") && str.contains("jono@ui.ac.id") && str.contains("jono123");
        });
    }

    @Override
    public AccountTest newInstance() {
        return new AccountTest();
    }

    @Override
    public void obtainPackage(String s) {
        Helper.makeAccessible = true;
        Account = new ClassR(s, "Account");
        ctor = Helper.getDeclaredConstructor(Account, int.class, String.class, String.class, String.class);
        toString = Helper.getDeclaredMethod(Account, "toString");
    }
}