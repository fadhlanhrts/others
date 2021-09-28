package modul3CSUT;

import com.Reflector.*;
import unithelper.Helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ComplainTest extends ReflectorUnitTest implements MonoPackageTester<ComplainTest>
{
    ClassR Complaint, Payment;
    Field idPayment,id, paymentId;
    Field desc;
    Constructor<?> ctor1, ctor2;

    @Override
    protected void scenario() {
        assumeModifier(ReflectorModifier.PUBLIC, ctor1);
        assumeModifier(ReflectorModifier.PUBLIC, ctor2);
        assumeModifier(ReflectorModifier.PUBLIC, id);
        assumeModifier(ReflectorModifier.PUBLIC, paymentId);
        assumeModifier(ReflectorModifier.PUBLIC, desc);

        assumeEquals("FileParser", () -> {
            return Complaint.getContainingClass().getInterfaces()[0].getSimpleName();
        });

        assumeEquals("Transaction", () -> {
            return Complaint.getContainingClass().getSuperclass().getSimpleName();
        });

        Object temp = null;

        try{
            Object pay = Payment.getBypassInstantiation();
            idPayment.set(pay, 5);
            temp = ctor1.newInstance(10, pay, "2");
        }catch (Throwable Ignore){ }

        final Object ctor1Object = temp;

        assumeEquals(10, () -> id.get(ctor1Object));
        assumeEquals(5, () -> paymentId.get(ctor1Object));
        assumeEquals("2", () -> desc.get(ctor1Object));

        try{
            temp = ctor2.newInstance(10, 1, 2, 3,"2");
        }catch (Throwable Ignore){ }

        final Object ctor2Object = temp;

        assumeEquals(10, () -> id.get(ctor2Object));
        assumeEquals(3, () -> paymentId.get(ctor2Object));
        assumeEquals("2", () -> desc.get(ctor2Object));
    }

    @Override
    public ComplainTest newInstance() {
        return new ComplainTest();
    }

    @Override
    public void obtainPackage(String s) {
        Helper.makeAccessible = true;
        Complaint   = new ClassR(s, "Complaint");
        Payment     = new ClassR(s, "Payment");
        ctor1       = Helper.getDeclaredConstructor(Complaint, int.class, Payment.getContainingClass(), String.class);
        ctor2       = Helper.getDeclaredConstructor(Complaint, int.class, int.class, int.class, int.class, String.class);
        idPayment   = Helper.getField(Payment,"id");
        id          = Helper.getField(Complaint,"id");
        paymentId   = Helper.getField(Complaint,"paymentId");
        desc        = Helper.getDeclaredField(Complaint, "desc");
    }
}
