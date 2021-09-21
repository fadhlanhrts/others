package modul2PTUT;

import com.Reflector.ClassR;
import com.Reflector.MonoPackageTester;
import com.Reflector.ReflectorModifier;
import com.Reflector.ReflectorUnitTest;

import java.lang.reflect.Method;
import unithelper.*;

public class JmartTest extends ReflectorUnitTest implements MonoPackageTester<JmartTest>
{
    ClassR Jmart;
    Method createProduct;
    Method createCoupon;
    Method createShipmentDuration;

    @Override
    protected void scenario()
    {
        assumeModifier(ReflectorModifier.PUBLIC, createProduct);
        assumeModifier(ReflectorModifier.STATIC, createProduct);

        /* bonus karena di UML typo, seharusnya createCoupon tetapi aslinya createCoupun
        assumeModifier(ReflectorModifier.PUBLIC, createCoupon);
        assumeModifier(ReflectorModifier.STATIC, createCoupon);
         */

        assumeModifier(ReflectorModifier.PUBLIC, createShipmentDuration);
        assumeModifier(ReflectorModifier.STATIC, createShipmentDuration);

        assumeTrue(() -> {
            return createProduct.getReturnType().getSimpleName().equals("Product");
        });

        assumeTrue(() -> {
            Object o = Jmart.getBypassInstantiation();
            Object prod = createProduct.invoke(o);
            return prod.getClass().getSimpleName().equals("Product");
        });

        /* bonus karena di UML typo, seharusnya createCoupon tetapi aslinya createCoupun
        assumeTrue(() -> {
            return createCoupon.getReturnType().getSimpleName().equals("Coupon");
        });

        assumeTrue(() -> {
            Object o = Jmart.getBypassInstantiation();
            Object prod = createCoupon.invoke(o);
            return prod.getClass().getSimpleName().equals("Coupon");
        });
        */

        assumeTrue(() -> {
            return createShipmentDuration.getReturnType().getSimpleName().equals("ShipmentDuration");
        });

        assumeTrue(() -> {
            Object o = Jmart.getBypassInstantiation();
            Object prod = createShipmentDuration.invoke(o);
            return prod.getClass().getSimpleName().equals("ShipmentDuration");
        });

    }

    @Override
    public JmartTest newInstance() {
        return new JmartTest();
    }

    @Override
    public void obtainPackage(String s) {
        Helper.makeAccessible  = true;
        Jmart                  = new ClassR(s, "Jmart");
        createProduct          = Helper.getDeclaredMethod(Jmart, "createProduct");
        createCoupon           = Helper.getDeclaredMethod(Jmart, "createCoupon");
        createShipmentDuration = Helper.getDeclaredMethod(Jmart, "createShipmentDuration");
    }
}
