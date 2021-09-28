package modul3CSUT;

import com.NetlabUT.*;
import com.Reflector.*;
import goldenSample.Account;
import unithelper.Helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.AcceptPendingException;

public class StoreTest extends ReflectorUnitTest implements MonoPackageTester<StoreTest> {
    ClassR Store, Account;
    Field id, accId;
    Field name, address, phoneNumber;
    Constructor<?> ctor1, ctor2;

    @Override
    protected void scenario() {
        assumeModifier(ReflectorModifier.PUBLIC, ctor1);
        assumeModifier(ReflectorModifier.PUBLIC, ctor2);
        assumeModifier(ReflectorModifier.PUBLIC, name);
        assumeModifier(ReflectorModifier.PUBLIC, address);
        assumeModifier(ReflectorModifier.PUBLIC, phoneNumber);

        assumeEquals("FileParser", () -> {
            return Store.getContainingClass().getInterfaces()[0].getSimpleName();
        });

        assumeEquals("Recognizable", () -> {
            return Store.getContainingClass().getSuperclass().getSimpleName();
        });

        assumeEquals(10, () -> {
            Object o = ctor1.newInstance(10, "1", "2", "3");
            return id.get(o);
        });

        assumeEquals("1", () -> {
            Object o = ctor1.newInstance(10, "1", "2", "3");
            return name.get(o);
        });

        assumeEquals("2", () -> {
            Object o = ctor1.newInstance(10, "1", "2", "3");
            return address.get(o);
        });

        assumeEquals("3", () -> {
            Object o = ctor1.newInstance(10, "1", "2", "3");
            return phoneNumber.get(o);
        });

        assumeEquals(10, () -> {
            Object acc = Account.getBypassInstantiation();
            accId.set(acc, 10);
            Object o = ctor2.newInstance(acc, "1", "2", "3");
            return id.get(o);
        });

        assumeEquals("1", () -> {
            Object acc = Account.getBypassInstantiation();
            Object o = ctor2.newInstance(acc, "1", "2", "3");
            return name.get(o);
        });

        assumeEquals("2", () -> {
            Object acc = Account.getBypassInstantiation();
            Object o = ctor2.newInstance(acc, "1", "2", "3");
            return address.get(o);
        });

        assumeEquals("3", () -> {
            Object acc = Account.getBypassInstantiation();
            Object o = ctor2.newInstance(acc, "1", "2", "3");
            return phoneNumber.get(o);
        });
    }

    @Override
    public StoreTest newInstance() {
        return new StoreTest();
    }

    @Override
    public void obtainPackage(String s) {
        Helper.makeAccessible = true;
        Store       = new ClassR(s, "Store");
        Account     = new ClassR(s, "Account");
        ctor1       = Helper.getDeclaredConstructor(Store, int.class, String.class, String.class, String.class);
        ctor2       = Helper.getDeclaredConstructor(Store, Account.getContainingClass(), String.class, String.class, String.class);
        accId       = Helper.getField(Account,"id");
        id          = Helper.getField(Store,"id");
        name        = Helper.getDeclaredField(Store, "name");
        address     = Helper.getDeclaredField(Store, "address");
        phoneNumber = Helper.getDeclaredField(Store, "phoneNumber");
    }
}
