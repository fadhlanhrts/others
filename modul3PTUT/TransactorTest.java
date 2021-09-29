package modul3PTUT;

import com.Reflector.ClassR;
import com.Reflector.MonoPackageTester;
import com.Reflector.ReflectorUnitTest;
import unithelper.ExtendedRUT;
import unithelper.Helper;

import java.lang.reflect.Method;

public class TransactorTest extends ExtendedRUT implements MonoPackageTester<TransactorTest>
{
    ClassR Transactor;
    Method validate, perform;

    @Override
    protected void scenario() {
        assumeTrue(() -> Transactor.getContainingClass().isInterface());
        assumeReturnType(boolean.class, validate);
        assumeEquals("Return Type", "Invoice", () -> perform.getReturnType().getSimpleName());
    }

    @Override
    public TransactorTest newInstance() {
        return new TransactorTest();
    }

    @Override
    public void obtainPackage(String s) {
        Helper.makeAccessible = true;
        Transactor = new ClassR(s, "Transactor");
        validate = Helper.getDeclaredMethod(Transactor, "validate");
        perform = Helper.getDeclaredMethod(Transactor, "perform");
    }
}