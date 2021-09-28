package modul3CSUT;

import com.Reflector.*;
import unithelper.Helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class TransactionTest extends ReflectorUnitTest implements MonoPackageTester<TransactionTest>
{
    ClassR Transaction, Account, Store;
    Field id, buyerId, storeId, idAccount, idStore;
    Constructor<?> ctor1, ctor2;

    @Override
    protected void scenario() {
        assumeModifier(ReflectorModifier.PROTECTED, ctor1);
        assumeModifier(ReflectorModifier.PROTECTED, ctor2);
        assumeModifier(ReflectorModifier.PUBLIC, id);
        assumeModifier(ReflectorModifier.PUBLIC, buyerId);
        assumeModifier(ReflectorModifier.PUBLIC, storeId);

        assumeEquals("Recognizable", () -> {
            return Transaction.getContainingClass().getSuperclass().getSimpleName();
        });
    }

    @Override
    public TransactionTest newInstance() {
        return new TransactionTest();
    }

    @Override
    public void obtainPackage(String s) {
        Helper.makeAccessible = true;
        Transaction = new ClassR(s, "Transaction");
        Account     = new ClassR(s, "Account");
        Store       = new ClassR(s, "Store");
        ctor1       = Helper.getDeclaredConstructor(Transaction, int.class, int.class, int.class);
        ctor2       = Helper.getDeclaredConstructor(Transaction, int.class, Account.getContainingClass(), Store.getContainingClass());
        id          = Helper.getField(Transaction,"id");
        buyerId     = Helper.getField(Transaction,"buyerId");
        storeId     = Helper.getField(Transaction,"storeId");
        idAccount   = Helper.getField(Account, "id");
        idStore     = Helper.getField(Store,"id");
    }
}