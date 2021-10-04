package modul4CSUT;

import com.Reflector.ClassR;
import com.Reflector.MonoPackageTester;
import com.Reflector.ReflectorModifier;

import goldenSample.Product;
import unithelper.ExtendedRUT;
import unithelper.Helper;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class FilterTest extends ExtendedRUT implements MonoPackageTester<FilterTest> {
    ClassR Filter, PriceTag, ProductRating;
    Method filterPriceTag, filterProductRating;
    Constructor<?> ctor;

    @Override
    public FilterTest newInstance() {
        return new FilterTest();
    }

    @Override
    public void obtainPackage(String s) {
        Helper.makeAccessible = true;
        Filter = new ClassR(s, "Filter");
        PriceTag = new ClassR(s, "PriceTag");
        // TO-DO : filterPriceTag
        filterProductRating = Helper.getDeclaredMethod(Filter, "filterProductRating", ArrayList.class, double.class,
                boolean.class);

    }

    @Override
    protected void scenario() {
        // assumeModifier(ReflectorModifier.PUBLIC, filterPriceTag);
        // assumeModifier(ReflectorModifier.STATIC, filterPriceTag);
        assumeModifier(ReflectorModifier.PUBLIC, filterProductRating);
        assumeModifier(ReflectorModifier.STATIC, filterProductRating);
        // TO-DO: cek hasil filterPriceTag sama filterProductRating
    }

}
