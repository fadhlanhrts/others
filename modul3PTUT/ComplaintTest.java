package modul3PTUT;

import com.Reflector.ClassR;
import com.Reflector.MonoPackageTester;
import com.Reflector.ReflectorModifier;
import com.Reflector.ReflectorUnitTest;
import unithelper.ExtendedRUT;
import unithelper.Helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ComplaintTest extends ExtendedRUT implements MonoPackageTester<ComplaintTest>
{
    ClassR Complaint;
    Constructor<?> ctor;
    Field date, desc;

    @Override
    protected void scenario() {
        assumeModifier(ReflectorModifier.PUBLIC, date);
        assumeModifier(ReflectorModifier.PUBLIC, desc);
        assumeModifier(ReflectorModifier.PUBLIC, ctor);

        assumeType(String.class, date);
        assumeType(String.class, desc);

        assumeEquals("Recognizable", () -> Complaint.getContainingClass().getSuperclass().getSimpleName());
        assumeEquals("FileParser", () -> Complaint.getContainingClass().getInterfaces()[0].getSimpleName());

        Object temp = null;
        try {
            temp = ctor.newInstance(1, "dessccripttion");
            assumeNotNull(date.get(temp)); // nilai tambahan jika ctor berhasil dipanggil
        }
        catch (Throwable ignored) {}

        final Object obj = temp;
        assumeEquals("dessccripttion", () -> desc.get(obj));

    }

    @Override
    public ComplaintTest newInstance() {
        return new ComplaintTest();
    }

    @Override
    public void obtainPackage(String s) {
        Helper.makeAccessible = true;
        Complaint = new ClassR(s, "Complaint");
        ctor = Helper.getDeclaredConstructor(Complaint, int.class, String.class);
        date = Helper.getDeclaredField(Complaint, "date");
        desc = Helper.getDeclaredField(Complaint, "desc");
    }
}