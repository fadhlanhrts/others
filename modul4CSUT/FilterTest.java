package modul4CSUT;

import com.Reflector.ClassR;
import com.Reflector.MonoPackageTester;
import com.Reflector.ReflectorModifier;

import goldenSample.Product;
import goldenSample.ProductRating;
import unithelper.ExtendedRUT;
import unithelper.Helper;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class FilterTest extends ExtendedRUT implements MonoPackageTester<FilterTest> {
    ClassR Filter, PriceTag, ProductRating;
    Method filterPriceTag, filterProductRating;
    Constructor<?> ctor, ctorPriceTag;

    Field total, count;

    @Override
    public FilterTest newInstance() {
        return new FilterTest();
    }

    @Override
    public void obtainPackage(String s)
    {
        Helper.makeAccessible = true;
        Filter = new ClassR(s, "Filter");
        
        PriceTag = new ClassR(s, "PriceTag");
        ctorPriceTag = Helper.getDeclaredConstructor(PriceTag, double.class);

        ProductRating = new ClassR(s, "ProductRating");
        total = Helper.getDeclaredField(ProductRating, "total");
        count = Helper.getDeclaredField(ProductRating, "count");
        
        filterProductRating = Helper.getDeclaredMethod(Filter, "filterProductRating", ArrayList.class, double.class, boolean.class);
        if (PriceTag.getContainingClass() != null)
        {
            Class<?> classPriceTagArray = Array.newInstance(PriceTag.getContainingClass(), 0).getClass();
            filterPriceTag = Helper.getDeclaredMethod(Filter, "filterPriceTag", classPriceTagArray, double.class, boolean.class);
            if (filterPriceTag == null)
                filterPriceTag = Helper.getDeclaredMethod(Filter, "filterPriceTag", classPriceTagArray, int.class, boolean.class);
        }   
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void scenario()
    {
        assumeModifier(ReflectorModifier.PUBLIC, filterPriceTag);
        assumeModifier(ReflectorModifier.STATIC, filterPriceTag);
        assumeModifier(ReflectorModifier.PUBLIC, filterProductRating);
        assumeModifier(ReflectorModifier.STATIC, filterProductRating);
       
        Object temp = null;
        try { temp = Filter.getBypassInstantiation(); }
        catch (Throwable ignored) {}
        final Object instance = temp;

        final Object[] arrPriceTag = createPriceTagArray(20000, 30000, 40000, 50000);

        assumeTrue(() -> {
            ArrayList<Object> obj = (ArrayList<Object>) filterPriceTag.invoke(instance, arrPriceTag, 30000, true);
            return obj.size() == 1 && obj.get(0) == arrPriceTag[0];
        });
        assumeTrue(() -> {
            ArrayList<Object> obj = (ArrayList<Object>) filterPriceTag.invoke(instance, arrPriceTag, 41000, true);
            return obj.size() == 2 && Helper.arrayContain(obj, arrPriceTag[0]) && Helper.arrayContain(obj, arrPriceTag[1]);
        });
        assumeTrue(() -> {
            ArrayList<Object> obj = (ArrayList<Object>) filterPriceTag.invoke(instance, arrPriceTag, 50000, false);
            return obj.size() == 1 && obj.get(0) == arrPriceTag[3];
        });
        assumeTrue(() -> {
            ArrayList<Object> obj = (ArrayList<Object>) filterPriceTag.invoke(instance, arrPriceTag, 41000, false);
            return obj.size() == 2 && Helper.arrayContain(obj, arrPriceTag[2]) && Helper.arrayContain(obj, arrPriceTag[3]);
        });
     
        final ArrayList<Object> arrProductRating = new ArrayList<>(4);
        arrProductRating.add(createProductRating(12, 4)); // rating avg 12 / 4 = 3.0
        arrProductRating.add(createProductRating(14, 4)); // rating avg 14 / 4 = 3.5
        arrProductRating.add(createProductRating(16, 4)); // rating avg 16 / 4 = 4.0
        arrProductRating.add(createProductRating(20, 4)); // rating avg 12 / 4 = 5.0

        /** ini bonus karena soal di CS ambigous, hapus comment ini jika tetap ingin mengecek kebenaran method
        assumeTrue(() -> {
            ArrayList<Object> obj = (ArrayList<Object>) arrProductRating.clone();
            filterProductRating.invoke(instance, obj, 4.5, true);
            return obj.size() == 1 && obj.get(0) == arrProductRating.get(3);
        });
        assumeTrue(() -> {
            ArrayList<Object> obj = (ArrayList<Object>) arrProductRating.clone();
            filterProductRating.invoke(instance, obj, 4.0, true);
            return obj.size() == 2 && Helper.arrayContain(obj, arrProductRating.get(2)) && Helper.arrayContain(obj, arrProductRating.get(3));
        });
        assumeTrue(() -> {
            ArrayList<Object> obj = (ArrayList<Object>) arrProductRating.clone();
            filterProductRating.invoke(instance, obj, 3.3, false);
            return obj.size() == 1 && obj.get(0) == arrProductRating.get(0);
        });
        assumeTrue(() -> {
            ArrayList<Object> obj = (ArrayList<Object>) arrProductRating.clone();
            filterProductRating.invoke(instance, obj, 3.5, false);
            return obj.size() == 1 && Helper.arrayContain(obj, arrProductRating.get(0));
        });
        assumeTrue(() -> {
            ArrayList<Object> obj = (ArrayList<Object>) arrProductRating.clone();
            filterProductRating.invoke(instance, obj, 3.6, false);
            return obj.size() == 2 && Helper.arrayContain(obj, arrProductRating.get(0)) && Helper.arrayContain(obj, arrProductRating.get(1));
        });
        */
    }

    private Object[] createPriceTagArray(double... e)
    {
        try {
            Object[] arr = (Object[]) Array.newInstance(PriceTag.getContainingClass(), e.length);
            for (int i = 0; i < e.length; ++i)
                arr[i] = ctorPriceTag.newInstance(e[i]);
            return arr;
        } catch (Throwable ignored) {}
        return null;
    }

    private Object createProductRating(long total, long count)
    {
        try {
            Object obj = ProductRating.getBypassInstantiation();
            this.total.set(obj, total);
            this.count.set(obj, count);
            return obj;
        } catch (Throwable ignored) {}
        return null;
    }

}
