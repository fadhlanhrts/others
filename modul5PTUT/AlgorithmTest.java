package modul5PTUT;

import static com.NetlabUT.Assumptions.*;
import static helper.Suppress.*;

import com.NetlabUT.Instantiator;
import com.NetlabUT.annotations.*;

import static helper.Stringify.*;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiConsumer;

@NetlabReflectTest(makeAccessible=true)
public class AlgorithmTest
{
	@ReflectClass
	Class<?> Algorithm;
	
	@ReflectClass
	Class<?> Predicate;
	
	class Parent implements Comparable<Parent> { 
		public int ival;
		public Parent(int ival) { this.ival = ival; }
		@Override
		public int compareTo(Parent other) { return Integer.compare(ival, other.ival); }
	}
	class Child extends Parent {
		public float fval;
		public Child(int ival, float fval) { super(ival); this.fval = fval; }
		public String toString() { return String.format("fval:%f, ival:%d", fval, ival); }
	}
	
	@Test
	void test()
	{
		Child minChild = new Child(-87, -87.0f);
		Child maxChild = new Child(99, 99.0f);
		
		ArrayList<Child> childIterable = new ArrayList<>(50);
		for (int i = 0; i < 50; ++i)
		{
			// randomize > 0 && < 90
			int val = ThreadLocalRandom.current().nextInt(90);
			childIterable.add(new Child(val, val));
		}
		
		// insert minimum aand maximum value in the array randomly
		int minChildIdx = ThreadLocalRandom.current().nextInt(40);
		int maxChildIdx = ThreadLocalRandom.current().nextInt(40);
		if (maxChildIdx == minChildIdx)
			maxChildIdx += 1;
		childIterable.set(minChildIdx, minChild);
		childIterable.set(maxChildIdx, maxChild);
		
		Child[] childs = childIterable.toArray(new Child[0]);
		
		Object instance = suppressNull(() -> Instantiator.getBypassInstantiation(Algorithm));
		
		Integer i76 = 76;
		Integer[] arr = { 1,2,i76,3,i76,4,5,6,7,8,9,10 };
		Iterable<Integer> iterable = Arrays.asList(arr);
		
		Object find76 = suppressNull(() -> Proxy.newProxyInstance(
				Predicate.getClassLoader(),
                new java.lang.Class[] { Predicate },
                new java.lang.reflect.InvocationHandler() {
		            @Override
		            public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args) throws java.lang.Throwable 
		            { return args[0].equals(76); }
        }));
		
		BiConsumer<Class<?>, Object> assumeCollectRoutine = (type, value) -> {
			Method method = suppressNull(() -> Algorithm.getDeclaredMethod("collect", type, Object.class));
			String methodName = String.format("collect(%s,Object)", type.getSimpleName());
			assumeTrue(methodName + " public modifier", () -> Modifier.isPublic(method.getModifiers()));
			assumeTrue(methodName + " static modifier", () -> Modifier.isStatic(method.getModifiers()));
			assumeTrue("collect value:" + i76, () -> {
				List list = (List) method.invoke(instance, value, i76);
				return list.size() == 2 && list.get(0).equals(i76) && list.get(1).equals(i76);
			});
		};
		
		BiConsumer<Class<?>, Object> assumeCollectPredicateRoutine = (type, value) -> {
			Method method = suppressNull(() -> Algorithm.getDeclaredMethod("collect", type, Predicate));
			String methodName = String.format("collect(%s,Object)", type.getSimpleName());
			assumeTrue(methodName + " public modifier", () -> Modifier.isPublic(method.getModifiers()));
			assumeTrue(methodName + " static modifier", () -> Modifier.isStatic(method.getModifiers()));
			assumeTrue("collect value:" + i76, () -> {
				List list = (List) method.invoke(instance, value, find76);
				return list.size() == 2 && list.get(0).equals(i76) && list.get(1).equals(i76);
			});
		};
		
		BiConsumer<Class<?>[], Object[]> assumeMinRoutine = (type, value) -> {
			Method method = suppressNull(() -> Algorithm.getDeclaredMethod("min", type));
			String methodName = String.format("min(%s)", arrToString(type, c -> c.getSimpleName()));
			assumeTrue(methodName + " public modifier", () -> Modifier.isPublic(method.getModifiers()));
			assumeTrue(methodName + " static modifier",() -> Modifier.isStatic(method.getModifiers()));
			assumeSame("minimum object", minChild, () -> method.invoke(instance, value));
		};
		
		BiConsumer<Class<?>[], Object[]> assumeMinComparatorRoutine = (type, value) -> {
			Method method = suppressNull(() -> Algorithm.getDeclaredMethod("min", type));
			String methodName = String.format("min(%s)", arrToString(type, c -> c.getSimpleName()));
			assumeTrue(methodName + " public modifier", () -> Modifier.isPublic(method.getModifiers()));
			assumeTrue(methodName + " static modifier",() -> Modifier.isStatic(method.getModifiers()));
			assumeSame("minimum object", minChild, () -> method.invoke(instance, value));
		};
		
		BiConsumer<Class<?>[], Object[]> assumeMaxRoutine = (type, value) -> {
			Method method = suppressNull(() -> Algorithm.getDeclaredMethod("max", type));
			String methodName = String.format("min(%s)", arrToString(type, c -> c.getSimpleName()));
			assumeTrue(methodName + " public modifier", () -> Modifier.isPublic(method.getModifiers()));
			assumeTrue(methodName + " static modifier",() -> Modifier.isStatic(method.getModifiers()));
			assumeSame("maximum object", maxChild, () -> method.invoke(instance, value));
		};
		
		BiConsumer<Class<?>[], Object[]> assumeMaxComparatorRoutine = (type, value) -> {
			Method method = suppressNull(() -> Algorithm.getDeclaredMethod("max", type));
			String methodName = String.format("min(%s)", arrToString(type, c -> c.getSimpleName()));
			assumeTrue(methodName + " public modifier", () -> Modifier.isPublic(method.getModifiers()));
			assumeTrue(methodName + " static modifier",() -> Modifier.isStatic(method.getModifiers()));
			assumeSame("maximum object", maxChild, () -> method.invoke(instance, value));
		};
		
		// collect
		{
			assumeCollectRoutine.accept(Object[].class, arr);
			assumeCollectRoutine.accept(Iterable.class, iterable);
			assumeCollectRoutine.accept(Iterator.class, iterable.iterator());
			
			assumeCollectPredicateRoutine.accept(Object[].class, arr);
			assumeCollectPredicateRoutine.accept(Iterable.class, iterable);
			assumeCollectPredicateRoutine.accept(Iterator.class, iterable.iterator());
		}
		// min
		{
			Comparator<Child> comp = (o1, o2) -> Float.compare(o1.fval, o2.fval);
			
			assumeMinRoutine.accept(new Class[]{Comparable[].class}, new Object[]{childs});
			assumeMinRoutine.accept(new Class[]{Iterable.class}, new Object[]{childIterable});
			assumeMinRoutine.accept(new Class[]{Iterator.class}, new Object[]{childIterable.iterator()});
			
			assumeMinComparatorRoutine.accept(new Class[]{Object.class, Object.class, Comparator.class}, new Object[]{maxChild, minChild, comp});
			assumeMinComparatorRoutine.accept(new Class[]{Object[].class, Comparator.class}, new Object[]{childs, comp});
			assumeMinComparatorRoutine.accept(new Class[]{Iterable.class, Comparator.class}, new Object[]{childIterable, comp});
			assumeMinComparatorRoutine.accept(new Class[]{Iterator.class, Comparator.class}, new Object[]{childIterable.iterator(), comp});
		}
		// max
		{
			Comparator<Child> comp = (o1, o2) -> Float.compare(o1.fval, o2.fval);
			
			assumeMaxRoutine.accept(new Class[]{Comparable[].class}, new Object[]{childs});
			assumeMaxRoutine.accept(new Class[]{Iterable.class}, new Object[]{childIterable});
			assumeMaxRoutine.accept(new Class[]{Iterator.class}, new Object[]{childIterable.iterator()});
			
			assumeMaxComparatorRoutine.accept(new Class[]{Object.class, Object.class, Comparator.class}, new Object[]{maxChild, minChild, comp});
			assumeMaxComparatorRoutine.accept(new Class[]{Object[].class, Comparator.class}, new Object[]{childs, comp});
			assumeMaxComparatorRoutine.accept(new Class[]{Iterable.class, Comparator.class}, new Object[]{childIterable, comp});
			assumeMaxComparatorRoutine.accept(new Class[]{Iterator.class, Comparator.class}, new Object[]{childIterable.iterator(), comp});
		}	
	}
}