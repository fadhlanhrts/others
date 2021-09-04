package modul1UT;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.Reflector.*;
import com.NetlabUT.*;

public class JmartTest extends ReflectorUnitTest implements MonoPackageTester<JmartTest>
{

	private ClassR Jmart;
	private Method main;
    private Method getPromo;
    private Method getCustomer;
    private Method getDiscount;
    
	@Override
	protected void scenario() {
		// TODO Auto-generated method stub
		assumeModifier(ReflectorModifier.PUBLIC, main);
		assumeModifier(ReflectorModifier.STATIC, main);
		assumeModifier(ReflectorModifier.PUBLIC, getPromo);
		assumeModifier(ReflectorModifier.STATIC, getPromo);
		assumeModifier(ReflectorModifier.PUBLIC, getCustomer);
		assumeModifier(ReflectorModifier.STATIC, getCustomer);
		assumeModifier(ReflectorModifier.PUBLIC, getDiscount);
		assumeModifier(ReflectorModifier.STATIC, getDiscount);
		
		assumeEquals(void.class, ()->main.getReturnType());
		assumeEquals(int.class, ()->getPromo.getReturnType());
		assumeEquals(String.class, ()->getCustomer.getReturnType());
		assumeEquals(float.class, ()->getDiscount.getReturnType());
	}

	@Override
	public JmartTest newInstance() {
		// TODO Auto-generated method stub
		return new JmartTest();
	}

	@Override
	public void obtainPackage(String packageName) {
		// TODO Auto-generated method stub
		this.Jmart = new ClassR(packageName, "Jmart");
		this.main = Jmart.getDeclaredMethod("main", String[].class);
		this.getPromo = Jmart.getDeclaredMethod("getPromo");
		this.getCustomer = Jmart.getDeclaredMethod("getCustomer");
		this.getDiscount = Jmart.getDeclaredMethod("getDiscount", int.class, int.class);
	}
	
}
