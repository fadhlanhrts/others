package modul5CSUT;

import static com.NetlabUT.Assumptions.*;
import com.NetlabUT.Instantiator;
import com.NetlabUT.annotations.*;

import static helper.Suppress.*;

import java.lang.reflect.*;

@NetlabReflectTest(makeAccessible=true)
public class RecognizableTest
{
	@ReflectClass
	Class<?> Recognizable;
	
	@ReflectField(owner="Recognizable")
	Field id;
	
	@ReflectMethod(owner="Recognizable", params={Class.class, int.class})
	Method setClosingId;
	
	@ReflectMethod(owner="Recognizable", params={Class.class})
	Method getClosingId;
	
	@Test
	void test()
	{
		Method compareTo = suppressNull(() -> Recognizable.getDeclaredMethod("compareTo", Recognizable));
		// access modifier
		{
			final String msgPublicModifier = "public modifier ";
			assumeTrue(() -> Modifier.isPublic(setClosingId.getModifiers()));
			assumeTrue(() -> Modifier.isPublic(getClosingId.getModifiers()));
			assumeTrue(() -> Modifier.isPublic(compareTo.getModifiers()));
		}
		// inherits Comparable
		{
			String comparableTypeName = suppressNull(() -> String.format("%s<%s>", Comparable.class.getName(), Recognizable.getName()));
			assumeEquals(Comparable.class, () -> Recognizable.getInterfaces()[0]);
			assumeEquals(comparableTypeName, () -> Recognizable.getGenericInterfaces()[0].getTypeName());
		}
		// Comparable compareTo
		{	
			Object o1 = suppressNull(() -> Instantiator.getBypassInstantiation(Recognizable));
			Object o2 = suppressNull(() -> Instantiator.getBypassInstantiation(Recognizable));
			
			suppressNull(() -> id.set(o1, 1));
			suppressNull(() -> id.set(o2, 2));
			
			assumeEquals(0, () -> compareTo.invoke(o1, o1));
			assumeEquals(-1, () -> compareTo.invoke(o1, o2));
			assumeEquals(1, () -> compareTo.invoke(o2, o1));
		}
	}
}
