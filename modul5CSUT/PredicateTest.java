package modul5CSUT;

import com.NetlabUT.annotations.*;
import static com.NetlabUT.Assumptions.*;

import java.lang.reflect.*;

@NetlabReflectTest(makeAccessible=true)
public class PredicateTest
{
	@ReflectClass
	public static Class<?> Predicate;
	
	@ReflectMethod(owner="Predicate", params={Object.class})
	Method predicate;
	
	@Test
	void test()
	{
		assumeTrue("is interface", () -> Predicate.isInterface());
		assumeEquals("predicate return type", boolean.class, () -> predicate.getReturnType());
		assumeTrue("predicate modifier public", () -> Modifier.isPublic(predicate.getModifiers()));
	}
}