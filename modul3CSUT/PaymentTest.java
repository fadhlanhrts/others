package modul3CSUT;

import com.NetlabUT.*;
import com.Reflector.*;
import goldenSample.Product;
import unithelper.Helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PaymentTest extends ReflectorUnitTest implements MonoPackageTester<PaymentTest> {
    ClassR Payment, ShipmentDuration, Product;
    Field productId, id, idProduct, shipmentDuration;
    Constructor<?> ctor1, ctor2;

    @Override
    protected void scenario() {
        assumeModifier(ReflectorModifier.PUBLIC, ctor1);
        assumeModifier(ReflectorModifier.PUBLIC, ctor2);
        assumeModifier(ReflectorModifier.PUBLIC, productId);
        assumeModifier(ReflectorModifier.PUBLIC, id);
        assumeModifier(ReflectorModifier.PUBLIC, shipmentDuration);

        assumeEquals("FileParser", () -> {
            return Payment.getContainingClass().getInterfaces()[0].getSimpleName();
        });

        assumeEquals("Transaction", () -> {
            return Payment.getContainingClass().getSuperclass().getSimpleName();
        });

        Object temp = null;
        Object duration = null;

        try {
            Object prod = Product.getBypassInstantiation();
            duration = ShipmentDuration.getBypassInstantiation();
            idProduct.set(prod, 3);
            temp = ctor1.newInstance(1, 2, prod, duration);
        } catch (Throwable Ignore) {
        }

        final Object ctor1Object = temp;

        assumeEquals(1, () -> id.get(ctor1Object));
        assumeEquals(3, () -> productId.get(ctor1Object));
        assumeSame(duration, () -> shipmentDuration.get(ctor1Object));

        try {
            duration = ShipmentDuration.getBypassInstantiation();
            temp = ctor2.newInstance(10, 1, 2, 3, duration);
        } catch (Throwable Ignore) {
        }

        final Object ctor2Object = temp;

        assumeEquals(10, () -> id.get(ctor2Object));
        assumeEquals(3, () -> productId.get(ctor2Object));
        assumeSame(duration, () -> shipmentDuration.get(ctor2Object));
    }

    @Override
    public PaymentTest newInstance() {
        return new PaymentTest();
    }

    @Override
    public void obtainPackage(String s) {
        Helper.makeAccessible = true;
        Payment = new ClassR(s, "Payment");
        ShipmentDuration = new ClassR(s, "ShipmentDuration");
        Product = new ClassR(s, "Product");
        ctor1 = Helper.getDeclaredConstructor(Payment, int.class, int.class, Product.getContainingClass(), ShipmentDuration.getContainingClass());
        ctor2 = Helper.getDeclaredConstructor(Payment, int.class, int.class, int.class, int.class, ShipmentDuration.getContainingClass());
        idProduct = Helper.getField(Product, "id");
        productId = Helper.getField(Payment, "productId");
        id = Helper.getField(Payment, "id");
        shipmentDuration = Helper.getDeclaredField(Payment, "shipmentDuration");
    }
}
