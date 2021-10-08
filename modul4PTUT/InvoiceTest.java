package modul4PTUT;

import com.Reflector.ClassR;
import com.Reflector.MonoPackageTester;
import com.Reflector.ReflectorModifier;
import unithelper.ExtendedRUT;
import unithelper.Helper;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceTest extends ExtendedRUT implements MonoPackageTester<InvoiceTest> {
    ClassR Invoice, Status;
    Constructor<?> ctor;
    Field history;
    
    ClassR Record;
    Field date, message, status;

    @Override
    public InvoiceTest newInstance() {
        return new InvoiceTest();
    }

    @Override
    public void obtainPackage(String s)
    {
        Helper.makeAccessible = true;
        Invoice = new ClassR(s, "Invoice");
        ctor = Helper.getDeclaredConstructor(Invoice, int.class, int.class, int.class);
        Record = new ClassR(s, "Invoice$Record");
        Status = new ClassR(s, "Invoice$Status");
        history = Helper.getDeclaredField(Invoice, "history");
        date = Helper.getDeclaredField(Record, "date");
        message = Helper.getDeclaredField(Record, "message");
        status = Helper.getDeclaredField(Record, "status");
    }

    @Override
    protected void scenario()
    {
    	assumeType(ArrayList.class, history);
    	assumeModifier(ReflectorModifier.PUBLIC, history);
    	
        assumeType(String.class, message);
        assumeType(Date.class, date);
        assumeEquals("Type", "Status", () -> status.getType().getSimpleName());
        
        assumeModifier(ReflectorModifier.PUBLIC, message);
        assumeModifier(ReflectorModifier.PUBLIC, date);
        assumeModifier(ReflectorModifier.PUBLIC, status);
    }

}
