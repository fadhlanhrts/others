package modul4CSUT;

import com.Reflector.ClassR;
import com.Reflector.MonoPackageTester;
import com.Reflector.ReflectorModifier;
import unithelper.ExtendedRUT;
import unithelper.Helper;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ComplaintTest extends ExtendedRUT implements MonoPackageTester<ComplaintTest>
{
    private ClassR Complaint;
    private Constructor<?> ctor;
    private Field date;

    @Override
    public ComplaintTest newInstance() { return new ComplaintTest();  }

    @Override
    public void obtainPackage(String s)
    {
        Helper.makeAccessible = true;
        Complaint = new ClassR(s, "Complaint");
        date = Helper.getDeclaredField(Complaint, "date");
        ctor = Helper.getDeclaredConstructor(Complaint, int.class, String.class);
    }

    @Override
    protected void scenario()
    {
        assumeModifier(ReflectorModifier.PUBLIC, date);
        assumeType(Date.class, date);

        assumeTrue("Date equal to now", () -> {
            Object obj = ctor.newInstance(0, "");
            Calendar actual = Calendar.getInstance();
            actual.setTime((Date) date.get(obj));
            Calendar ref = Calendar.getInstance();
            ref.setTime(new Date());
            return actual.get(Calendar.DAY_OF_YEAR) == ref.get(Calendar.DAY_OF_YEAR);
        });
    }

}
