package modul3CSUT;

import com.NetlabUT.*;
import com.Reflector.*;
import unithelper.Helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RecognizableTest extends ReflectorUnitTest implements MonoPackageTester<RecognizableTest>
{
    ClassR Recognizable;
    Field id;
    Constructor<?> ctor;
    Method equals1, equals2;

    @Override
    protected void scenario() {
        assumeModifier(ReflectorModifier.PROTECTED, ctor);
        assumeModifier(ReflectorModifier.PUBLIC, id);
        assumeModifier(ReflectorModifier.PUBLIC, equals1);
        assumeModifier(ReflectorModifier.PUBLIC, equals2);
    }

    @Override
    public RecognizableTest newInstance() {
        return new RecognizableTest();
    }

    @Override
    public void obtainPackage(String s) {
        Helper.makeAccessible = true;
        Recognizable    = new ClassR(s, "Recognizable");
        ctor            = Helper.getDeclaredConstructor(Recognizable, int.class);
        id              = Helper.getField(Recognizable, "id");
        equals1         = Helper.getDeclaredMethod(Recognizable, "equals", Object.class);
        equals2         = Helper.getDeclaredMethod(Recognizable, "equals", Recognizable.getContainingClass());
    }
}
