package modul4PTUT;

import com.Reflector.ClassR;
import com.Reflector.MonoPackageTester;
import com.Reflector.ReflectorModifier;
import unithelper.ExtendedRUT;
import unithelper.Helper;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Date;

public class InvoiceTest extends ExtendedRUT implements MonoPackageTester<InvoiceTest> {
    ClassR Invoice, Record, Status;
    Constructor<?> ctor;
    Field message;

    @Override
    public InvoiceTest newInstance() {
        return new InvoiceTest();
    }

    @Override
    public void obtainPackage(String s) {
        Helper.makeAccessible = true;
        Invoice = new ClassR(s, "Invoice");
        ctor = Helper.getDeclaredConstructor(Invoice, int.class, int.class, int.class);
        Record = new ClassR(s, "Invoice$Record");
        Status = new ClassR(s, "Invoice$Status");

    }

    @Override
    protected void scenario() {
        assumeType(Status.getContainingClass(), Record.getDeclaredField("status"));
        assumeType(String.class, Record.getDeclaredField("message"));
        assumeType(Date.class, Record.getDeclaredField("date"));
    }

}
