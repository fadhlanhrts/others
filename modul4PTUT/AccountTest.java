package modul4PTUT;

import com.Reflector.ClassR;
import com.Reflector.MonoPackageTester;
import com.Reflector.ReflectorModifier;
import com.Reflector.ReflectorUnitTest;
import unithelper.Helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AccountTest extends ReflectorUnitTest implements MonoPackageTester<AccountTest> {
    ClassR Account;
    Constructor<?> ctor;
    Method validate;

    @Override
    protected void scenario() {
        assumeModifier(ReflectorModifier.PUBLIC, validate);
        assumeEquals(boolean.class, () -> validate.getReturnType());
        assumeTrue(() -> {
            Object obj = ctor.newInstance(0, "Jono", "jono@ui.ac.id", "Martin123@123");
            boolean res = (boolean) validate.invoke(obj);
            return res;
        });
        assumeFalse(() -> {
            Object obj = ctor.newInstance(0, "Jono", "jonoui.ac.id", "martin123@123");
            boolean res = (boolean) validate.invoke(obj);
            return res;
        });
        assumeFalse(() -> {
            Object obj = ctor.newInstance(0, "Jono", "jono@ui.ac.id", "martin123@123");
            boolean res = (boolean) validate.invoke(obj);
            return res;
        });
        assumeFalse(() -> {
            Object obj = ctor.newInstance(0, "Jono", "jonoui.ac.id", "Martin123@123");
            boolean res = (boolean) validate.invoke(obj);
            return res;
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
        validate = Helper.getDeclaredMethod(Account, "validate");
    }
}