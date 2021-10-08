package modul4PTUT;

import com.Reflector.ClassR;
import com.Reflector.MonoPackageTester;
import com.Reflector.ReflectorModifier;
import unithelper.ExtendedRUT;
import unithelper.Helper;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class ComplaintTest extends ExtendedRUT implements MonoPackageTester<ComplaintTest> {
    ClassR Complaint;
    Method toString;
    Constructor<?> ctor;
    Field date, desc;
    
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd/MM/yyyy");
    private static final Pattern REGEX_TOSTRING = Pattern.compile("^Complaint\\{[= , \\s ' / \\d \\w]*\\}$");

    @Override
    public ComplaintTest newInstance() {
        return new ComplaintTest();
    }

    @Override
    public void obtainPackage(String s)
    {
        Helper.makeAccessible = true;
        Complaint = new ClassR(s, "Complaint");
        ctor      = Helper.getDeclaredConstructor(Complaint, int.class, String.class);
        date      = Helper.getDeclaredField(Complaint, "date");
        desc      = Helper.getDeclaredField(Complaint, "desc");
        toString  = Helper.getDeclaredMethod(Complaint, "toString");
    }

    @Override
    protected void scenario() {
        assumeType(Date.class, date);
        assumeModifier(ReflectorModifier.PUBLIC, date);
        assumeModifier(ReflectorModifier.PUBLIC, toString);
       
        assumeTrue(REGEX_TOSTRING.toString(), () -> {
        	Object obj = ctor.newInstance(1, "pengiriman kilat wes apik tenan");
            String actual = (String) toString.invoke(obj);
            return REGEX_TOSTRING.matcher(actual).matches();
        });
        assumeTrue("date=%s", () -> {
        	Object obj = ctor.newInstance(1, "pengiriman kilat wes apik tenan");
        	Date objDate = (Date) date.get(obj);
            String actual = (String) toString.invoke(obj);
            return actual.contains(String.format("date=%s", FORMATTER.format(objDate)));
        });
        assumeTrue("desc='%s'", () -> {
        	Object obj = ctor.newInstance(1, "pengiriman kilat wes apik tenan");
        	String objDesc = (String) desc.get(obj);
            String actual = (String) toString.invoke(obj);
            return actual.contains(String.format("desc='%s'", objDesc));
        });
    }

}
