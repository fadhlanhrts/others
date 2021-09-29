package unithelper;

import com.Reflector.ClassR;
import com.Reflector.ReflectorUnitTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class ExtendedRUT extends ReflectorUnitTest
{
    protected void assumeEnumMember(ClassR clazz, String... fields)
    {
        final Class<?> cclass = clazz.getContainingClass();
        assumeTrue("is Enum: " + cclass, () -> cclass.isEnum());
        assumeTrue("is Member Class: " + cclass, () -> cclass.isMemberClass());
        for (String field : fields)
            assumeTrue("is Enum Constant: " + field, () -> clazz.getDeclaredField(field).isEnumConstant());
    }
    protected void assumeType(Class<?> clazz, Field field)
    {
        assumeEquals("Type", clazz, () -> field.getType());
    }
    protected void assumeReturnType(Class<?> clazz, Method method)
    {
        assumeEquals("Return Type", clazz, () -> method.getReturnType());
    }
}
