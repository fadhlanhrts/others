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
    Field discount;
    Field price;

    Constructor<?> ctor1;
    Constructor<?> ctor2;

    Method getAdjustedPrice;
    Method getAdminFee;

    private void setAccessible(AccessibleObject object)
    {
        if (object != null)
            object.setAccessible(true);
    }

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
        this.discount = PriceTag.getDeclaredField("discount");
        this.price = PriceTag.getDeclaredField("price");

        this.ctor1 = PriceTag.getConstructor(float.class);
        this.ctor2 = PriceTag.getConstructor(float.class, float.class);

        this.getAdjustedPrice = PriceTag.getMethod("getAdjustedPrice");
        this.getAdminFee = PriceTag.getMethod("getAdminFee");

        setAccessible(COMMISSION_MULTIPLIER);
        setAccessible(discount);
        setAccessible(price);
        setAccessible(ctor1);
        setAccessible(ctor2);
        setAccessible(getAdjustedPrice);
        setAccessible(getAdminFee);
    }

    @Override
    protected void scenario()
    {
        assumeModifier(ReflectorModifier.PUBLIC, COMMISSION_MULTIPLIER);
        assumeModifier(ReflectorModifier.STATIC, COMMISSION_MULTIPLIER);
        assumeModifier(ReflectorModifier.FINAL, COMMISSION_MULTIPLIER);
        assumeModifier(ReflectorModifier.PUBLIC, discount);
        assumeModifier(ReflectorModifier.PUBLIC, price);

        assumeReturnType(float.class, getAdjustedPrice);
        assumeReturnType(float.class, getAdminFee);

        Object get = null;
        try { get = PriceTag.getBypassInstantiation(); }
        catch (Throwable ignored) {}

        final Object bypass = get;
        assumeEquals(0.05f, () -> COMMISSION_MULTIPLIER.get(bypass));
    }
}
