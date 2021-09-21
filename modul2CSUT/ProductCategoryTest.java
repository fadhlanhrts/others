package modul2UT;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import com.Reflector.*;
import com.NetlabUT.*;

public class ProductCategoryTest extends ReflectorUnitTest implements MonoPackageTester<ProductCategoryTest> 
{
    ClassR ItemCategory;
    ArrayList<Field> ConstantList = new ArrayList<Field>();

    @Override
    public ProductCategoryTest newInstance() {
        return new ProductCategoryTest();
    }

    @Override
    public void obtainPackage(String arg0) {
        this.ItemCategory = new ClassR(arg0, "ProductCategory");
        ConstantList.add(ItemCategory.getDeclaredField("BOOK"));
        ConstantList.add(ItemCategory.getDeclaredField("KITCHEN"));
        ConstantList.add(ItemCategory.getDeclaredField("ELECTRONIC"));
        ConstantList.add(ItemCategory.getDeclaredField("FASHION"));
        ConstantList.add(ItemCategory.getDeclaredField("GAMING"));
        ConstantList.add(ItemCategory.getDeclaredField("GADGET"));
        ConstantList.add(ItemCategory.getDeclaredField("MOTHERCARE"));
        ConstantList.add(ItemCategory.getDeclaredField("COSMETICS"));
        ConstantList.add(ItemCategory.getDeclaredField("HEALTHCARE"));
        ConstantList.add(ItemCategory.getDeclaredField("FURNITURE"));
        ConstantList.add(ItemCategory.getDeclaredField("JEWELRY"));
        ConstantList.add(ItemCategory.getDeclaredField("TOYS"));
        ConstantList.add(ItemCategory.getDeclaredField("FNB"));
        ConstantList.add(ItemCategory.getDeclaredField("STATIONERY"));
        ConstantList.add(ItemCategory.getDeclaredField("SPORTS"));
        ConstantList.add(ItemCategory.getDeclaredField("AUTOMOTIVE"));
        ConstantList.add(ItemCategory.getDeclaredField("PETCARE"));
        ConstantList.add(ItemCategory.getDeclaredField("ART_CRAFT"));
        ConstantList.add(ItemCategory.getDeclaredField("CARPENTRY"));
        ConstantList.add(ItemCategory.getDeclaredField("MISCELLANEOUS"));
        ConstantList.add(ItemCategory.getDeclaredField("PROPERTY"));
        ConstantList.add(ItemCategory.getDeclaredField("TRAVEL"));
        ConstantList.add(ItemCategory.getDeclaredField("WEDDING"));
    }

    @Override
    protected void scenario()
    {
        for (Field f : ConstantList)
        {
            assumeNotNull("field not null", f);
            assumeTrue("is enum constant", () -> f.isEnumConstant());
        }
    }
}
