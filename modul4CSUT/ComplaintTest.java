package modul4CSUT;

import com.Reflector.ClassR;
import com.Reflector.MonoPackageTester;
import com.Reflector.ReflectorModifier;
import unithelper.ExtendedRUT;
import unithelper.Helper;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Date;

public class ComplaintTest extends ExtendedRUT implements MonoPackageTester<ComplaintTest> {
    ClassR Invoice;
    Constructor<?> ctor;
    Field date;

    @Override
    public ComplaintTest newInstance() {
        return new ComplaintTest();
    }

    @Override
    public void obtainPackage(String s) {
        Helper.makeAccessible = true;
        Invoice = new ClassR(s, "Complaint");
        date = Helper.getDeclaredField(Invoice, "date");
    }

    @Override
    protected void scenario() {
        assumeModifier(ReflectorModifier.PUBLIC, date);
        assumeType(Date.class, date);
    }

}
