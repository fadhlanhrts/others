package modul2UT;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import com.Reflector.*;
import com.NetlabUT.*;

public class PriceTagTest extends ReflectorUnitTest implements MonoPackageTester<PriceTagTest> 
{
    ClassR PriceTag;

    Field COMMISSION_MULTIPLIER;
    Field BOTTOM_PRICE;
    Field BOTTOM_FEE;
    Field discount;
    Field price;

    Constructor<?> ctor1;
    Constructor<?> ctor2;

    Method getAdjustedPrice;
    Method getAdminFee;
    Method getDiscountedPrice;

    protected void assumeModifier(ReflectorModifier modifier, Method method)
	{
		final String prefix = "Modifier of: ";
		final String msg = method == null ? prefix + "null" : prefix + method.getName();
		assumeModifier(msg, modifier, method);
	}

    protected void assumeModifier(ReflectorModifier modifier, Field field)
	{
		final String prefix = "Modifier of: ";
		final String msg = field == null ? prefix + "null" : prefix + field.getName();
		assumeModifier(msg, modifier, field);
	}

	protected void assumeReturnType(Class<?> type, Method method)
	{
		final String prefix = "Return type of: ";
		final String msg = method == null ? prefix + "null" : prefix + method.getName();
		assumeEquals(msg, type, () -> method.getReturnType());
	}

	protected void assumeEquals(Object expected, Method method, Object obj, Object... args)
	{
		final String prefixMethod = "Method called: ";
		final String prefixArgs   = "Given args: ";
		final String msg = method == null ? 
			prefixMethod + "null" + " | " + prefixArgs + StringFormatter.arrToString(args) :
			prefixMethod + method.getName() + " | " + prefixArgs + StringFormatter.arrToString(args);
		assumeEquals(msg, expected, method, obj, args);
	}

    @Override
    public PriceTagTest newInstance() {
        return new PriceTagTest();
    }

    @Override
    public void obtainPackage(String arg0)
    {
        this.PriceTag = new ClassR(arg0, "PriceTag");

        this.COMMISSION_MULTIPLIER = PriceTag.getDeclaredField("COMMISSION_MULTIPLIER");
        this.BOTTOM_FEE = PriceTag.getDeclaredField("BOTTOM_FEE");
        this.BOTTOM_PRICE = PriceTag.getDeclaredField("BOTTOM_PRICE");
        this.discount = PriceTag.getDeclaredField("discount");
        this.price = PriceTag.getDeclaredField("price");

        this.ctor1 = PriceTag.getDeclaredConstructor(double.class);
        this.ctor2 = PriceTag.getDeclaredConstructor(double.class, double.class);

        this.getAdjustedPrice = PriceTag.getDeclaredMethod("getAdjustedPrice");
        this.getAdminFee = PriceTag.getDeclaredMethod("getAdminFee");
        this.getDiscountedPrice = PriceTag.getDeclaredMethod("getDiscountedPrice");

        Helper.setAccessible(COMMISSION_MULTIPLIER);
        Helper.setAccessible(BOTTOM_FEE);
        Helper.setAccessible(BOTTOM_PRICE);
        Helper.setAccessible(discount);
        Helper.setAccessible(price);
        Helper.setAccessible(ctor1);
        Helper.setAccessible(ctor2);
        Helper.setAccessible(getAdjustedPrice);
        Helper.setAccessible(getAdminFee);
        Helper.setAccessible(getDiscountedPrice);
    }

    @Override
    protected void scenario()
    {
        assumeModifier(ReflectorModifier.PUBLIC, COMMISSION_MULTIPLIER);
        assumeModifier(ReflectorModifier.STATIC, COMMISSION_MULTIPLIER);
        assumeModifier(ReflectorModifier.FINAL,  COMMISSION_MULTIPLIER);
        assumeModifier(ReflectorModifier.PUBLIC, BOTTOM_FEE);
        assumeModifier(ReflectorModifier.STATIC, BOTTOM_FEE);
        assumeModifier(ReflectorModifier.FINAL,  BOTTOM_FEE);
        assumeModifier(ReflectorModifier.PUBLIC, BOTTOM_PRICE);
        assumeModifier(ReflectorModifier.STATIC, BOTTOM_PRICE);
        assumeModifier(ReflectorModifier.FINAL,  BOTTOM_PRICE);
        assumeModifier(ReflectorModifier.PUBLIC, discount);
        assumeModifier(ReflectorModifier.PUBLIC, price);

        assumeModifier(ReflectorModifier.PUBLIC, ctor1);
        assumeModifier(ReflectorModifier.PUBLIC, ctor2);

        assumeModifier(ReflectorModifier.PUBLIC, getAdminFee);
        assumeModifier(ReflectorModifier.PUBLIC, getAdjustedPrice);
        assumeModifier(ReflectorModifier.PRIVATE, getDiscountedPrice);

        assumeReturnType(double.class, getAdjustedPrice);
        assumeReturnType(double.class, getAdminFee);
        assumeReturnType(double.class, getDiscountedPrice);

        Object get = null;
        try { get = PriceTag.getBypassInstantiation(); }
        catch (Throwable ignored) {}
        final Object bypass = get;
        
        assumeEquals(0.05, () -> COMMISSION_MULTIPLIER.get(bypass));
        assumeEquals(20000.0, () -> BOTTOM_PRICE.get(bypass));
        assumeEquals(1000.0, () -> BOTTOM_FEE.get(bypass));

        {
            Object o = PriceTag.newInstance(ctor1, 9.5);
            assumeEquals(9.5, () -> price.get(o));
            assumeEquals(0.0, () -> discount.get(o));
        }

        {
            Object o = PriceTag.newInstance(ctor2, 11.0, 9.0);
            assumeEquals(11.0, () -> price.get(o));
            assumeEquals(9.0, () -> discount.get(o));
        }

        assumeEquals(1000.0, () -> {
            price.set(bypass, 5000);
            discount.set(bypass, 0);
            return getAdminFee.invoke(bypass);
        });
        assumeEquals(5000.0, () -> getDiscountedPrice.invoke(bypass));
        assumeEquals(6000.0, () -> getAdjustedPrice.invoke(bypass));
        assumeEquals(1000.0, () -> {
            price.set(bypass, 0);
            discount.set(bypass, 0);
            return getAdminFee.invoke(bypass);
        });
        assumeEquals(0.0, () -> getDiscountedPrice.invoke(bypass));
        assumeEquals(1000.0, () -> getAdjustedPrice.invoke(bypass));
        assumeEquals(1000.0, () -> {
            price.set(bypass, 0);
            discount.set(bypass, 10);
            return getAdminFee.invoke(bypass);
        });
        assumeEquals(0.0, () -> getDiscountedPrice.invoke(bypass));
        assumeEquals(1000.0, () -> getAdjustedPrice.invoke(bypass));
        assumeEquals(1000.0, () -> {
            price.set(bypass, 5000);
            discount.set(bypass, 10);
            return getAdminFee.invoke(bypass);
        });
        assumeEquals(4500.0, () -> getDiscountedPrice.invoke(bypass));
        assumeEquals(5500.0, () -> getAdjustedPrice.invoke(bypass));
        assumeEquals(1000.0, () -> {
            price.set(bypass, 20000);
            discount.set(bypass, 0);
            return getAdminFee.invoke(bypass);
        });
        assumeEquals(20000.0, () -> getDiscountedPrice.invoke(bypass));
        assumeEquals(21000.0, () -> getAdjustedPrice.invoke(bypass));
        assumeEquals(1000.0, () -> {
            price.set(bypass, 25000);
            discount.set(bypass, 50);
            return getAdminFee.invoke(bypass);
        });
        assumeEquals(12500.0, () -> getDiscountedPrice.invoke(bypass));
        assumeEquals(13500.0, () -> getAdjustedPrice.invoke(bypass));
        assumeEquals(1350.0, () -> {
            price.set(bypass, 30000);
            discount.set(bypass, 10);
            return getAdminFee.invoke(bypass);
        });
        assumeEquals(27000.0, () -> getDiscountedPrice.invoke(bypass));
        assumeEquals(28350.0, () -> getAdjustedPrice.invoke(bypass));
        assumeEquals(1000.0, () -> {
            price.set(bypass, 30000);
            discount.set(bypass, 100);
            return getAdminFee.invoke(bypass);
        });
        assumeEquals(0.0, () -> getDiscountedPrice.invoke(bypass));
        assumeEquals(1000.0, () -> getAdjustedPrice.invoke(bypass));
        assumeEquals(1000.0, () -> {
            price.set(bypass, 30000);
            discount.set(bypass, 2000);
            return getAdminFee.invoke(bypass);
        });
        assumeEquals(0.0, () -> getDiscountedPrice.invoke(bypass));
        assumeEquals(1000.0, () -> getAdjustedPrice.invoke(bypass));
    }
}
