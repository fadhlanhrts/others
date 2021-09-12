package modul1UT;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import com.Reflector.*;
import com.NetlabUT.*;

public class JmartTest extends ReflectorUnitTest implements MonoPackageTester<JmartTest>
{

	private ClassR Jmart;
	private Method main;
    private Method getPromo;
    private Method getCustomer;
    private Method getDiscountPercentage;
	private Method getDiscountedPrice;
	private Method getCommissionMultiplier;
	private Method getAdjustedPrice;
	private Method getAdminFee;
	private Method getOriginalPrice;

	protected void assumeModifier(ReflectorModifier modifier, Method method)
	{
		final String prefix = "Modifier of: ";
		final String msg = method == null ? prefix + "null" : prefix + method.getName();
		assumeModifier(msg, modifier, method);
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
	protected void scenario()
	{	
		assumeModifier(ReflectorModifier.PUBLIC, main);
		assumeModifier(ReflectorModifier.STATIC, main);
		assumeModifier(ReflectorModifier.PUBLIC, getPromo);
		assumeModifier(ReflectorModifier.STATIC, getPromo);
		assumeModifier(ReflectorModifier.PUBLIC, getCustomer);
		assumeModifier(ReflectorModifier.STATIC, getCustomer);
		assumeModifier(ReflectorModifier.PUBLIC, getDiscountPercentage);
		assumeModifier(ReflectorModifier.STATIC, getDiscountPercentage);
		assumeModifier(ReflectorModifier.PUBLIC, getDiscountedPrice);
		assumeModifier(ReflectorModifier.STATIC, getDiscountedPrice);
		assumeModifier(ReflectorModifier.PUBLIC, getCommissionMultiplier);
		assumeModifier(ReflectorModifier.STATIC, getCommissionMultiplier);
		assumeModifier(ReflectorModifier.PUBLIC, getAdjustedPrice);
		assumeModifier(ReflectorModifier.STATIC, getAdjustedPrice);
		
		assumeReturnType(void.class,   main);
		assumeReturnType(int.class,    getPromo);
		assumeReturnType(String.class, getCustomer);
		assumeReturnType(float.class,  getDiscountPercentage);
		assumeReturnType(int.class,    getDiscountedPrice);
		assumeReturnType(float.class,  getCommissionMultiplier);
		assumeReturnType(int.class,    getAdjustedPrice);

		// just in case if the declared method is not static
		Object instance = null;
		try { instance =Jmart.getBypassInstantiation(); }
		catch(Throwable ignored) {}

		assumeEquals(0, getPromo, instance);
		assumeEquals((Object) "oop", getCustomer, instance);

		assumeEquals(10.0f, getDiscountPercentage, instance, 10000, 9000);
		assumeEquals(25.0f, getDiscountPercentage, instance, 10000, 7500);
		assumeEquals(44.5f, getDiscountPercentage, instance, 10000, 5550);
		assumeEquals(100.0f, getDiscountPercentage, instance, 10000, 0);
		assumeEquals(0.0f, getDiscountPercentage, instance, 10000, 10001);
		assumeEquals(0.0f, getDiscountPercentage, instance, 0, 1);
		assumeEquals(0.0f, getDiscountPercentage, instance, 0, 0);
		
		assumeEquals(9000, getDiscountedPrice, instance, 10000, 10.0f);
		assumeEquals(7500, getDiscountedPrice, instance, 10000, 25.0f);
		assumeEquals(5550, getDiscountedPrice, instance, 10000, 44.5f);
		assumeEquals(0, getDiscountedPrice, instance, 10000, 100.0f);
		assumeEquals(0, getDiscountedPrice, instance, 10000, 120.0f);
		assumeEquals(0, getDiscountedPrice, instance, 0, 120.0f);
		assumeEquals(0, getDiscountedPrice, instance, 0, 50.0f);

		assumeEquals(10000, getOriginalPrice, instance, 9000, 10.0f);
		assumeEquals(10000, getOriginalPrice, instance, 7500, 25.0f);
		assumeEquals(10000, getOriginalPrice, instance, 5550, 44.5f);
		assumeEquals(0, getOriginalPrice, instance, 0, 100.0f);
		assumeEquals(0, getOriginalPrice, instance, 0, 120.0f);
		assumeEquals(0, getOriginalPrice, instance, 0, 50.0f);

		assumeEquals(0.05f, getCommissionMultiplier, instance);

		assumeEquals(10500, getAdjustedPrice, instance, 10000);
		assumeEquals(5250, getAdjustedPrice, instance, 5000);
		assumeEquals(0, getAdjustedPrice, instance, 0);

		assumeEquals(500, getAdminFee, instance, 10000);
		assumeEquals(250, getAdminFee, instance, 5000);
		assumeEquals(0, getAdminFee, instance, 0);
	}

	@Override
	public JmartTest newInstance() { return new JmartTest(); }

	@Override
	public void obtainPackage(String packageName)
	{
		this.Jmart                    = new ClassR(packageName, "Jmart");
		ArrayList<Throwable> throwableList = Jmart.getThrowableList();
		this.main                     = Jmart.getDeclaredMethod("main", String[].class);
		this.getPromo                 = Jmart.getDeclaredMethod("getPromo");
		this.getCustomer              = Jmart.getDeclaredMethod("getCustomer");
		this.getDiscountPercentage    = Jmart.getDeclaredMethod("getDiscountPercentage", int.class, int.class);
		this.getDiscountedPrice       = Jmart.getDeclaredMethod("getDiscountedPrice", int.class, float.class);
		this.getCommissionMultiplier  = Jmart.getDeclaredMethod("getCommissionMultiplier");
		this.getAdjustedPrice         = Jmart.getDeclaredMethod("getAdjustedPrice", int.class);
		this.getAdminFee         	  = Jmart.getDeclaredMethod("getAdminFee", int.class);
		this.getOriginalPrice         = Jmart.getDeclaredMethod("getOriginalPrice", int.class, float.class);
		
		if (getPromo != null) 					getPromo.setAccessible(true);
		if (getCustomer != null) 				getCustomer.setAccessible(true);
		if (getDiscountPercentage != null) 		getDiscountPercentage.setAccessible(true);
		if (getDiscountedPrice != null) 		getDiscountedPrice.setAccessible(true);
		if (getCommissionMultiplier != null) 	getCommissionMultiplier.setAccessible(true);
		if (getAdjustedPrice != null) 			getAdjustedPrice.setAccessible(true);
		if (getAdminFee != null) 			    getAdminFee.setAccessible(true);
		if (getOriginalPrice != null) 			getOriginalPrice.setAccessible(true);
	}
}
