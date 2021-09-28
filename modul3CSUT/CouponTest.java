package modul3CSUT;

import com.Reflector.ClassR;
import com.Reflector.MonoPackageTester;
import com.Reflector.ReflectorModifier;
import com.Reflector.ReflectorUnitTest;
import unithelper.Helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class CouponTest extends ReflectorUnitTest implements MonoPackageTester<CouponTest> {
    ClassR Coupon, Type;
    Constructor<?> ctor;
    Field id;

    @Override
    protected void scenario() {
        assumeModifier(ReflectorModifier.PUBLIC, ctor);

        assumeEquals("FileParser", () -> {
            return Coupon.getContainingClass().getInterfaces()[0].getSimpleName();
        });

        assumeEquals("Recognizable", () -> {
            return Coupon.getContainingClass().getSuperclass().getSimpleName();
        });

        assumeEquals(1, () -> {
            Object o = ctor.newInstance(1, null, 2, null, 0.1, 0.2);
            return id.get(o);
        });
    }

    @Override
    public CouponTest newInstance() {
        return new CouponTest();
    }

    @Override
    public void obtainPackage(String s) {
        Coupon = new ClassR(s, "Coupon");
        Type = new ClassR(s, "Coupon$Type");
        id    = Helper.getField(Coupon, "id");
        ctor = Coupon.getDeclaredConstructor(int.class, String.class, int.class, Type.getContainingClass(),
                double.class, double.class);
    }
}
