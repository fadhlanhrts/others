package modul2PTUT;

import com.Reflector.*;

import unithelper.Helper;

import java.lang.reflect.*;

public class CouponTest extends ReflectorUnitTest implements MonoPackageTester<CouponTest>
{
    ClassR Coupon;
    ClassR Type;

    ClassR PriceTag;
    Field discount;
    Field price;

    Field name;
    Field code;
    Field cut;
    Field type;
    Field minimum;
    Field used;

    Constructor<?> ctor1;

    Method isUsed;
    Method canApply;
    Method apply;

    @Override
    public CouponTest newInstance()
    {
        return new CouponTest();
    }

    @Override
    public void obtainPackage(String arg0)
    {
        Helper.makeAccessible = true;
        Coupon = new ClassR(arg0, "Coupon");
        PriceTag = new ClassR(arg0, "PriceTag");
        Type = new ClassR(arg0, "Coupon$Type");
        discount = Helper.getDeclaredField(PriceTag, "discount");
        price = Helper.getDeclaredField(PriceTag, "price");

        name = Helper.getDeclaredField(Coupon, "name");
        code = Helper.getDeclaredField(Coupon, "code");
        cut = Helper.getDeclaredField(Coupon, "cut");
        type = Helper.getDeclaredField(Coupon, "type");
        minimum = Helper.getDeclaredField(Coupon, "minimum");
        used = Helper.getDeclaredField(Coupon, "used");
    
        ctor1 = Helper.getDeclaredConstructor(Coupon, String.class, int.class);
        
        isUsed = Helper.getDeclaredMethod(Coupon, "isUsed");
        canApply = Helper.getDeclaredMethod(Coupon, "canApply", PriceTag.getContainingClass());
        apply = Helper.getDeclaredMethod(Coupon, "apply", PriceTag.getContainingClass());
    }

    @Override
    protected void scenario()
    {
        assumeTrue(() -> {
            return Type.getDeclaredField("DISCOUNT").isEnumConstant();
        });
        assumeTrue(() -> {
            return Type.getDeclaredField("REBATE").isEnumConstant();
        });

        assumeModifier(ReflectorModifier.PUBLIC, name);
        assumeModifier(ReflectorModifier.FINAL, name);
        assumeModifier(ReflectorModifier.PUBLIC, code);
        assumeModifier(ReflectorModifier.FINAL, code);
        assumeModifier(ReflectorModifier.PUBLIC, cut);
        assumeModifier(ReflectorModifier.FINAL, cut);
        assumeModifier(ReflectorModifier.PUBLIC, type);
        assumeModifier(ReflectorModifier.FINAL, type);
        assumeModifier(ReflectorModifier.PUBLIC, minimum);
        assumeModifier(ReflectorModifier.FINAL, minimum);
        assumeModifier(ReflectorModifier.PRIVATE, used);

        assumeModifier(ReflectorModifier.PUBLIC, isUsed);
        assumeModifier(ReflectorModifier.PUBLIC, canApply);
        assumeModifier(ReflectorModifier.PUBLIC, apply);

        Object get = null;
        try { get = Coupon.getBypassInstantiation(); }
        catch (Throwable throwable) {}

        final Object coupon = get;

        try { get = PriceTag.getBypassInstantiation(); }
        catch (Throwable throwable) {}

        final Object pt = get;

        assumeTrue(() -> {
            used.set(coupon, false);
            boolean first = used.getBoolean(coupon);
            used.set(coupon, true);
            boolean second = used.getBoolean(coupon);
            return first == false && second == true;
        });

        assumeTrue(() -> {
            used.set(coupon, false);
            price.set(pt, 10000);
            discount.set(pt, 0);
            return canApply.invoke(coupon, pt);
        });

        assumeFalse(() -> {
            used.set(coupon, true);
            return canApply.invoke(coupon, pt);
        });

        assumeFalse(() -> {
            used.set(coupon, true);
            minimum.set(coupon, 1000);
            price.set(pt, 2000);
            return canApply.invoke(coupon, pt);
        });

        assumeTrue(() -> {
            used.set(coupon, false);
            minimum.set(coupon, 10000);
            price.set(pt, 20000);
            discount.set(pt, 50);
            return canApply.invoke(coupon, pt);
        });

        assumeTrue(() -> {
            used.set(coupon, false);
            minimum.set(coupon, 10000);
            price.set(pt, 20000);
            discount.set(pt, 55);
            return canApply.invoke(coupon, pt);
        });

        assumeFalse(() -> {
            used.set(coupon, false);
            minimum.set(coupon, 10000);
            price.set(pt, 20000);
            discount.set(pt, 58);
            return canApply.invoke(coupon, pt);
        });

        assumeTrue(() -> {
            type.set(coupon, Type.getBypassInstantiation());
            price.set(pt, 0);
            discount.set(pt, 0);
            apply.invoke(coupon, pt);
            return used.get(coupon);
        });

        assumeEquals(2000.0, () -> {
            type.set(coupon, Type.getDeclaredField("REBATE").get(null));
            price.set(pt, 5000);
            discount.set(pt, 0);
            cut.set(coupon, 4000);
            return apply.invoke(coupon, pt);
        });

        assumeEquals(5000.0, () -> {
            type.set(coupon, Type.getDeclaredField("REBATE").get(null));
            price.set(pt, 5000);
            discount.set(pt, 0);
            cut.set(coupon, 1000);
            return apply.invoke(coupon, pt);
        });
        
        assumeEquals(3000.0, () -> {
            type.set(coupon, Type.getDeclaredField("DISCOUNT").get(null));
            price.set(pt, 5000);
            discount.set(pt, 0);
            cut.set(coupon, 50);
            return apply.invoke(coupon, pt);
        });

        assumeEquals(9000.0, () -> {
            type.set(coupon, Type.getDeclaredField("DISCOUNT").get(null));
            price.set(pt, 9000);
            discount.set(pt, 0);
            cut.set(coupon, 10);
            return apply.invoke(coupon, pt);
        });
    }
    
}
