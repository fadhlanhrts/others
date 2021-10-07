package modul4CSUT;

import com.Reflector.ClassR;
import com.Reflector.MonoPackageTester;
import com.Reflector.ReflectorModifier;
import unithelper.ExtendedRUT;
import unithelper.Helper;
import java.lang.reflect.Field;
import java.util.Date;

public class InvoiceTest extends ExtendedRUT implements MonoPackageTester<InvoiceTest>
{
    ClassR Invoice;
    Field date;

    @Override
    public InvoiceTest newInstance() { return new InvoiceTest(); }

    @Override
    public void obtainPackage(String s)
    {
        Helper.makeAccessible = true;
        Invoice = new ClassR(s, "Invoice");
        date = Helper.getDeclaredField(Invoice, "date");
    }

    @Override
    protected void scenario() {
        assumeModifier(ReflectorModifier.PUBLIC, date);
        assumeType(Date.class, date);
    }

}
