package modul2CSUT;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import com.Reflector.*;
import unithelper.*;

public class ProductTest extends ReflectorUnitTest implements MonoPackageTester<ProductTest> 
{
    ClassR Product;
    ClassR ProductRating;
    ClassR ProductCategory;
    ClassR PriceTag;

    Constructor<?> ctor1;

    Field idCounter;
    Field id;
    Field name;
    Field weight;
    Field conditionUsed;
    Field priceTag;
    Field category;
    Field rating;

    @Override
    public ProductTest newInstance() {
        return new ProductTest();
    }

    @Override
    public void obtainPackage(String arg0) {
        Product = new ClassR(arg0, "Product");
        ProductRating = new ClassR(arg0, "ProductRating");
        ProductCategory = new ClassR(arg0, "ProductCategory");
        PriceTag = new ClassR(arg0, "PriceTag");
        ctor1 = Product.getDeclaredConstructor(String.class, int.class, boolean.class,
                PriceTag.getContainingClass(), ProductCategory.getContainingClass());
        idCounter = Product.getDeclaredField("idCounter");
        id = Product.getDeclaredField("id");
        name = Product.getDeclaredField("name");
        weight = Product.getDeclaredField("weight");
        conditionUsed = Product.getDeclaredField("conditionUsed");
        priceTag = Product.getDeclaredField("priceTag");
        category = Product.getDeclaredField("category");
        rating = Product.getDeclaredField("rating");

        Helper.setAccessible(idCounter);
        Helper.setAccessible(id);
        Helper.setAccessible(name);
        Helper.setAccessible(weight);
        Helper.setAccessible(conditionUsed);
        Helper.setAccessible(priceTag);
        Helper.setAccessible(category);
        Helper.setAccessible(rating);
    }

    @Override
    protected void scenario() {
        assumeModifier(ReflectorModifier.PRIVATE, idCounter);
        assumeModifier(ReflectorModifier.STATIC, idCounter);
        assumeModifier(ReflectorModifier.PUBLIC, id);
        assumeModifier(ReflectorModifier.PUBLIC, name);
        assumeModifier(ReflectorModifier.PUBLIC, weight);
        assumeModifier(ReflectorModifier.PUBLIC, conditionUsed);
        assumeModifier(ReflectorModifier.PUBLIC, priceTag);
        assumeModifier(ReflectorModifier.PUBLIC, category);
        assumeModifier(ReflectorModifier.PUBLIC, rating);
        assumeModifier(ReflectorModifier.PUBLIC, ctor1);
        // instantiation test
        {
            Object o1 = Product.newInstance(ctor1, "1", 1, false, null, null);
            Object o2 = Product.newInstance(ctor1, "2", 2, true, null, null);

            assumeEquals(0, () -> id.get(o1));
            assumeEquals(1, () -> id.get(o2));

            assumeEquals("1", () -> name.get(o1));
            assumeEquals("2", () -> name.get(o2));

            assumeEquals(1, () -> weight.get(o1));
            assumeEquals(2, () -> weight.get(o2));

            assumeNotNull(() -> rating.get(o1));
            assumeNotNull(() -> rating.get(o2));

            assumeTrue(() -> {
                Object instance = PriceTag.getBypassInstantiation();
                Object o = Product.newInstance(ctor1, "1", 1, false, instance, null);
                return priceTag.get(o) == instance;
            });
        }
    }
    
}
