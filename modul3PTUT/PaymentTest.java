package modul3PTUT;

import com.Reflector.ClassR;
import com.Reflector.MonoPackageTester;
import com.Reflector.ReflectorModifier;
import com.Reflector.ReflectorUnitTest;
import unithelper.ExtendedRUT;
import unithelper.Helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class PaymentTest extends ExtendedRUT implements MonoPackageTester<PaymentTest>
{
    ClassR Payment;
    ClassR Invoice, Transactor, Shipment;
    Constructor<?> ctor;
    Field shipment, productCount;

    @Override
    protected void scenario() {
        assumeModifier(ReflectorModifier.PUBLIC, ctor);
        assumeModifier(ReflectorModifier.PUBLIC, shipment);
        assumeModifier(ReflectorModifier.PUBLIC, productCount);

        assumeType(Shipment.getContainingClass(), shipment);
        assumeType(int.class, productCount);

        assumeEquals("Invoice", () -> Payment.getContainingClass().getSuperclass().getSimpleName());
        assumeEquals("Transactor", () -> Payment.getContainingClass().getInterfaces()[0].getSimpleName());

        Object temp = null;
        try { temp = ctor.newInstance(1,2,3,4,null); }
        catch (Throwable throwable) {}

        final Object obj = temp;
        assumeEquals(4, () -> productCount.get(obj));
    }

    @Override
    public PaymentTest newInstance() {
        return new PaymentTest();
    }

    @Override
    public void obtainPackage(String s) {
        Helper.makeAccessible = true;
        Payment = new ClassR(s, "Payment");
        Invoice = new ClassR(s, "Invoice");
        Transactor = new ClassR(s, "Transactor");
        Shipment = new ClassR(s, "Shipment");
        ctor = Helper.getDeclaredConstructor(Payment, int.class, int.class, int.class, int.class, Shipment.getContainingClass());
        shipment = Helper.getDeclaredField(Payment, "shipment");
        productCount = Helper.getDeclaredField(Payment, "productCount");
    }
}