package modul3PTUT;

import com.Reflector.ClassR;
import com.Reflector.MonoPackageTester;
import com.Reflector.ReflectorModifier;
import com.Reflector.ReflectorUnitTest;
import unithelper.Helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ProductTest extends ReflectorUnitTest implements MonoPackageTester<ProductTest>
{
    ClassR Product;
    ClassR PriceTag;
    ClassR ProductCategory;
    ClassR MultiDuration;
    Constructor<?> ctor;
    Method toString;

    @Override
    protected void scenario() {
        assumeModifier(ReflectorModifier.PUBLIC, toString);
        assumeEquals(String.class, () -> toString.getReturnType());
        assumeNotNull(ctor);
        assumeTrue(() -> {
            Object obj = ctor.newInstance(1, 2, "Harry", 3, false,
                    PriceTag.getBypassInstantiation(),
                    ProductCategory.getBypassInstantiation(),
                    MultiDuration.getBypassInstantiation());
            String str = (String) toString.invoke(obj);
            return  str.contains("2") && str.contains("Harry") &&
                    str.contains("3") && str.contains("false");
        });
    }

    @Override
    public ProductTest newInstance() {
        return new ProductTest();
    }

    @Override
    public void obtainPackage(String s) {
        Helper.makeAccessible = true;
        Product = new ClassR(s, "Product");
        PriceTag = new ClassR(s, "PriceTag");
        ProductCategory = new ClassR(s, "ProductCategory");
        MultiDuration = new ClassR(s, "Shipment$MultiDuration");
        ctor = Helper.getDeclaredConstructor(Product, int.class, int.class, String.class, int.class,
                boolean.class, PriceTag.getContainingClass(), ProductCategory.getContainingClass(), MultiDuration.getContainingClass());
        toString = Helper.getDeclaredMethod(Product, "toString");
    }
}