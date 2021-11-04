package modul5CSUT;

import com.NetlabUT.annotations.*;
import static com.NetlabUT.Assumptions.*;
import static helper.Suppress.*;

import java.lang.reflect.*;

@NetlabReflectTest(makeAccessible=true)
public class PairTest
{
	@ReflectClass
	Class<?> Pair;
	
	@ReflectField(owner="Pair")
	Field first, second;
	
	@ReflectCtor(owner="Pair", params={})
	Constructor<?> ctor0; 
	
	@ReflectCtor(owner="Pair", params={Object.class, Object.class})
	Constructor<?> ctor1;
	
	@Test
	void test()
	{
		// assume generic type of T and U
		{
			assumeEquals("T", () -> first.getGenericType().toString());
			assumeEquals("U", () -> second.getGenericType().toString());
		}
		// access modifier
		{
			assumeTrue(() -> Modifier.isPublic(first.getModifiers()));
			assumeTrue(() -> Modifier.isPublic(second.getModifiers()));
			assumeTrue(() -> Modifier.isPublic(ctor0.getModifiers()));
			assumeTrue(() -> Modifier.isPublic(ctor1.getModifiers()));
		}
		// test default constructor
		{
			Object instance = suppressNull(() -> ctor0.newInstance());
			assumeNull(() -> first.get(instance));
			assumeNull(() -> second.get(instance));
		}
		// test constructor assignment
		{
			Object instance = suppressNull(() -> ctor1.newInstance("Netlab2021", 99));
			assumeEquals("Netlab2021", () -> first.get(instance));
			assumeEquals(99, () -> second.get(instance));
		}
		
	}
}
