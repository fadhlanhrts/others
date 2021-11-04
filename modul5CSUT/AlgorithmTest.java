package modul5CSUT;

import static com.NetlabUT.Assumptions.*;
import static helper.Suppress.*;

import com.NetlabUT.Instantiator;
import com.NetlabUT.annotations.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.BiConsumer;

@NetlabReflectTest(makeAccessible=true)
public class AlgorithmTest
{
	@ReflectClass
	Class<?> Algorithm;
	
	@ReflectCtor(owner="Algorithm", params={})
	Constructor<?> ctor0;
	
	@Test
	void test()
	{
		Object instance = suppressNull(() -> Instantiator.getBypassInstantiation(Algorithm));
		
		Integer[] arrPrimitive = { 1,3,5,5,7,9,11,13,15 };
		Iterable<Integer> arrIterable = Arrays.asList(arrPrimitive);
		
		Object find5 = suppressNull(() -> Proxy.newProxyInstance(
				PredicateTest.Predicate.getClassLoader(),
                new java.lang.Class[] { PredicateTest.Predicate },
                new java.lang.reflect.InvocationHandler() {
		            @Override
		            public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args) throws java.lang.Throwable 
		            { return args[0].equals(5); }
        }));
		
		Object find2 = suppressNull(() -> Proxy.newProxyInstance(
				PredicateTest.Predicate.getClassLoader(),
                new java.lang.Class[] { PredicateTest.Predicate },
                new java.lang.reflect.InvocationHandler() {
		            @Override
		            public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args) throws java.lang.Throwable 
		            { return args[0].equals(2); }
        }));
		
		BiConsumer<Class<?>, Object> assumeCountRoutine = (type, value) -> {
			Method count = suppressNull(() -> Algorithm.getDeclaredMethod("count", type, Object.class));
			assumeTrue(() -> Modifier.isPublic(count.getModifiers()));
			assumeEquals(int.class, () -> count.getReturnType());
			assumeEquals(2, () -> count.invoke(instance, value, 5));
			assumeEquals(0, () -> count.invoke(instance, value, 2));
		};
		
		BiConsumer<Class<?>, Object> assumeCountPredicateRoutine = (type, value) -> {
			Method count = suppressNull(() -> Algorithm.getDeclaredMethod("count", type, PredicateTest.Predicate));
			assumeTrue(() -> Modifier.isPublic(count.getModifiers()));
			assumeEquals(int.class, () -> count.getReturnType());
			assumeEquals(2, () -> count.invoke(instance, value, find5));
			assumeEquals(0, () -> count.invoke(instance, value, find2));
		};
		
		BiConsumer<Class<?>, Object> assumeFindRoutine = (type, value) -> {
			Method find = suppressNull(() -> Algorithm.getDeclaredMethod("find", type, Object.class));
			assumeTrue(() -> Modifier.isPublic(find.getModifiers()));
			assumeEquals(Object.class, () -> find.getReturnType());
			assumeEquals(5, () -> find.invoke(instance, value, 5));
			assumeNull(() -> find.invoke(instance, value, 2));
		};
		
		BiConsumer<Class<?>, Object> assumeFindPredicateRoutine = (type, value) -> {
			Method find = suppressNull(() -> Algorithm.getDeclaredMethod("find", type, PredicateTest.Predicate));
			assumeTrue(() -> Modifier.isPublic(find.getModifiers()));
			assumeEquals(Object.class, () -> find.getReturnType());
			assumeEquals(5, () -> find.invoke(instance, value, find5));
			assumeNull(() -> find.invoke(instance, value, find2));
		};
		
		BiConsumer<Class<?>, Object> assumeExistsRoutine = (type, value) -> {
			Method exists = suppressNull(() -> Algorithm.getDeclaredMethod("exists", type, Object.class));
			assumeTrue(() -> Modifier.isPublic(exists.getModifiers()));
			assumeEquals(boolean.class, () -> exists.getReturnType());
			assumeTrue(() -> exists.invoke(instance, value, 5));
			assumeFalse(() -> exists.invoke(instance, value, 2));
		};
		
		BiConsumer<Class<?>, Object> assumeExistsPredicateRoutine = (type, value) -> {
			Method exists = suppressNull(() -> Algorithm.getDeclaredMethod("exists", type, PredicateTest.Predicate));
			assumeTrue(() -> Modifier.isPublic(exists.getModifiers()));
			assumeEquals(boolean.class, () -> exists.getReturnType());
			assumeTrue(() -> exists.invoke(instance, value, find5));
			assumeFalse(() -> exists.invoke(instance, value, find2));;
		};
		
		// ctor
		{
			assumeTrue(() -> Modifier.isPrivate(ctor0.getModifiers()));
		}
		// count
		{
			assumeCountRoutine.accept(Object[].class, arrPrimitive);
			assumeCountRoutine.accept(Iterable.class, arrIterable);
			assumeCountRoutine.accept(Iterator.class, arrIterable.iterator());
			
			assumeCountPredicateRoutine.accept(Object[].class, arrPrimitive);
			assumeCountPredicateRoutine.accept(Iterable.class, arrIterable);
			assumeCountPredicateRoutine.accept(Iterator.class, arrIterable.iterator());
		}
		// find
		{
			assumeFindRoutine.accept(Object[].class, arrPrimitive);
			assumeFindRoutine.accept(Iterable.class, arrIterable);
			assumeFindRoutine.accept(Iterator.class, arrIterable.iterator());
			
			assumeFindPredicateRoutine.accept(Object[].class, arrPrimitive);
			assumeFindPredicateRoutine.accept(Iterable.class, arrIterable);
			assumeFindPredicateRoutine.accept(Iterator.class, arrIterable.iterator());
		}
		// exists
		{
			assumeExistsRoutine.accept(Object[].class, arrPrimitive);
			assumeExistsRoutine.accept(Iterable.class, arrIterable);
			assumeExistsRoutine.accept(Iterator.class, arrIterable.iterator());
			
			assumeExistsPredicateRoutine.accept(Object[].class, arrPrimitive);
			assumeExistsPredicateRoutine.accept(Iterable.class, arrIterable);
			assumeExistsPredicateRoutine.accept(Iterator.class, arrIterable.iterator());
		}
		// min and max
		{
			Method min = suppressNull(() -> Algorithm.getDeclaredMethod("min", Comparable.class, Comparable.class));
			Method max = suppressNull(() -> Algorithm.getDeclaredMethod("max", Comparable.class, Comparable.class));
			
			assumeTrue(() -> Modifier.isPublic(min.getModifiers()));
			assumeTrue(() -> Modifier.isPublic(max.getModifiers()));
			
			assumeEquals(Comparable.class, () -> min.getReturnType());
			assumeEquals(Comparable.class, () -> max.getReturnType());
			
			assumeEquals(9, () -> min.invoke(instance, 15, 9));
			assumeEquals(1, () -> min.invoke(instance, 1, 1));
			assumeEquals(15, () -> max.invoke(instance, 15, 9));
			assumeEquals(8, () -> max.invoke(instance, 8, 8));
		}
	}
}
