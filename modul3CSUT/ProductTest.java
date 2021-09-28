package modul3CSUT;

import com.Reflector.ClassR;
import com.Reflector.MonoPackageTester;
import com.Reflector.ReflectorModifier;
import com.Reflector.ReflectorUnitTest;
import unithelper.Helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ProductTest extends ReflectorUnitTest implements MonoPackageTester<ProductTest>
{
    ClassR Product, ProductCategory, PriceTag, Store;
    Field id;
    Constructor<?> ctor1, ctor2;

    @Override
    protected void scenario() {
        assumeModifier(ReflectorModifier.PUBLIC, ctor1);
        assumeModifier(ReflectorModifier.PUBLIC, ctor2);

        assumeEquals("FileParser", () -> {
            return Product.getContainingClass().getInterfaces()[0].getSimpleName();
        });

        assumeEquals("Recognizable", () -> {
            return Product.getContainingClass().getSuperclass().getSimpleName();
        });

        assumeEquals(1, () -> {
            Object o = ctor1.newInstance(1, 2, null, 3, false, null, null);
            return id.get(o);
        });
    }

    @Override
    public ProductTest newInstance() {
        return new ProductTest();
    }

    @Override
    public void obtainPackage(String s) {
        Product = new ClassR(s, "Product");
        ProductCategory = new ClassR(s, "ProductCategory");
        PriceTag = new ClassR(s, "PriceTag");
        Store = new ClassR(s, "Store");
        ctor1 = Product.getDeclaredConstructor(int.class, int.class, String.class,int.class, boolean.class,
                PriceTag.getContainingClass(), ProductCategory.getContainingClass());
        ctor2 = Product.getDeclaredConstructor(int.class, Store.getContainingClass(), String.class,int.class, boolean.class,
                PriceTag.getContainingClass(), ProductCategory.getContainingClass());
        id    = Helper.getField(Product, "id");
    }
}
