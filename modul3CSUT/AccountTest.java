package modul3CSUT;

import com.NetlabUT.*;
import com.Reflector.*;
import unithelper.Helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AccountTest extends ReflectorUnitTest implements MonoPackageTester<AccountTest>
{
    ClassR Account;
    Field id;
    Field name, email, password;
    Constructor<?> ctor;
    Method read;

    @Override
    protected void scenario()
    {
        assumeModifier(ReflectorModifier.PUBLIC, ctor);
        assumeModifier(ReflectorModifier.PUBLIC, name);
        assumeModifier(ReflectorModifier.PUBLIC, email);
        assumeModifier(ReflectorModifier.PUBLIC, password);
        assumeModifier(ReflectorModifier.PUBLIC, read);

        assumeEquals(boolean.class, () -> read.getReturnType());

        assumeEquals("FileParser", () -> {
            return Account.getContainingClass().getInterfaces()[0].getSimpleName();
        });

        assumeEquals("Recognizable", () -> {
            return Account.getContainingClass().getSuperclass().getSimpleName();
        });

        assumeEquals(10, () -> {
            Object o = ctor.newInstance(10, "1", "2", "3");
            return id.get(o);
        });

        assumeEquals("1", () -> {
            Object o = ctor.newInstance(10, "1", "2", "3");
            return name.get(o);
        });

        assumeEquals("2", () -> {
            Object o = ctor.newInstance(10, "1", "2", "3");
            return email.get(o);
        });

        assumeEquals("3", () -> {
            Object o = ctor.newInstance(10, "1", "2", "3");
            return password.get(o);
        });
    }

    @Override
    public AccountTest newInstance()
    {
        return new AccountTest();
    }

    @Override
    public void obtainPackage(String s)
    {
        Helper.makeAccessible = true;
        Account     = new ClassR(s, "Account");
        ctor        = Helper.getDeclaredConstructor(Account, int.class, String.class, String.class, String.class);
        // karena id bukan milik account maka tidak bisa pake "getDeclaredField";
        id          = Account.getField("id");
        name        = Helper.getDeclaredField(Account, "name");
        email       = Helper.getDeclaredField(Account, "email");
        password    = Helper.getDeclaredField(Account, "password");
        read        = Helper.getDeclaredMethod(Account, "read", String.class);
    }
}
