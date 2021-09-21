package modul2CSUT;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.Reflector.*;
import unithelper.*;

public class ProductRatingTest extends ReflectorUnitTest implements MonoPackageTester<ProductRatingTest> 
{
    ClassR ProductRating;

    Constructor<?> ctor0;

    Field total;
    Field count;

    Method insert;
    Method getAverage;
    Method getCount;
    Method getTotal;

    @Override
    public ProductRatingTest newInstance() {
        return new ProductRatingTest();
    }

    @Override
    public void obtainPackage(String arg0) {
        ProductRating = new ClassR(arg0, "ProductRating");
        ctor0 = ProductRating.getDeclaredConstructor();
        total = ProductRating.getDeclaredField("total");
        count = ProductRating.getDeclaredField("count");
        insert = ProductRating.getDeclaredMethod("insert", int.class);
        getAverage = ProductRating.getDeclaredMethod("getAverage");
        getCount = ProductRating.getDeclaredMethod("getCount");
        getTotal = ProductRating.getDeclaredMethod("getTotal");
        Helper.setAccessible(ctor0);
        Helper.setAccessible(total);
        Helper.setAccessible(count);
        Helper.setAccessible(insert);
        Helper.setAccessible(getAverage);
        Helper.setAccessible(getCount);
        Helper.setAccessible(getTotal);
    }

    @Override
    protected void scenario() {
        assumeModifier(ReflectorModifier.PRIVATE, total);
        assumeModifier(ReflectorModifier.PRIVATE, count);

        assumeModifier(ReflectorModifier.PUBLIC, ctor0);
        assumeModifier(ReflectorModifier.PUBLIC, insert);
        assumeModifier(ReflectorModifier.PUBLIC, getAverage);
        assumeModifier(ReflectorModifier.PUBLIC, getCount);
        assumeModifier(ReflectorModifier.PUBLIC, getTotal);

        {
            Object o = ProductRating.newInstance(ctor0);
            assumeEquals(0L, () -> total.get(o));
            assumeEquals(0L, () -> count.get(o));
        }

        Object getObject = null;
        try { getObject = ProductRating.getBypassInstantiation(); }
        catch (Throwable ignored) {}
        final Object bypass = getObject;

        // test getTotal
        assumeEquals(69L, () -> {
            total.set(bypass, 69);
            return getTotal.invoke(bypass);
        });
        assumeEquals(85L, () -> {
            total.set(bypass, 85);
            return getTotal.invoke(bypass);
        });
        // test getCount
        assumeEquals(69L, () -> {
            count.set(bypass, 69);
            return getCount.invoke(bypass);
        });
        assumeEquals(85L, () -> {
            count.set(bypass, 85);
            return getCount.invoke(bypass);
        });
        // test increment count on method insert(int)
        assumeEquals(1L, () -> {
            count.set(bypass, 0);
            insert.invoke(bypass, 5);
            return count.get(bypass);
        });
        assumeEquals(2L, () -> {
            insert.invoke(bypass, 5);
            return count.get(bypass);
        });
        // test increment total on method insert(int)
        assumeEquals(3L, () -> {
            total.set(bypass, 0);
            insert.invoke(bypass, 3);
            return total.get(bypass);
        });
        assumeEquals(13L, () -> {
            insert.invoke(bypass, 10);
            return total.get(bypass);
        });
        // test getAverage()
        assumeEquals(0.0, () -> {
            total.set(bypass, 0);
            count.set(bypass, 0);
            return getAverage.invoke(bypass);
        });
        assumeEquals(5.0, () -> {
            total.set(bypass, 5);
            count.set(bypass, 1);
            return getAverage.invoke(bypass);
        });
        assumeEquals(4.0, () -> {
            total.set(bypass, 200);
            count.set(bypass, 50);
            return getAverage.invoke(bypass);
        });
    }
}
