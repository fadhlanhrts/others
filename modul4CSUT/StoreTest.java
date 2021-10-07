package modul4CSUT;

import com.Reflector.ClassR;
import com.Reflector.MonoPackageTester;
import com.Reflector.ReflectorModifier;
import unithelper.ExtendedRUT;
import unithelper.Helper;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.reflect.Method;

public class StoreTest extends ExtendedRUT implements MonoPackageTester<StoreTest> {
    ClassR Store;
    Constructor<?> ctor;
    Field REGEX_NAME, REGEX_PHONE, date;
    Method validate;

    @Override
    public StoreTest newInstance() {
        return new StoreTest();
    }

    @Override
    public void obtainPackage(String s) {
        Helper.makeAccessible = true;
        Store = new ClassR(s, "Store");
        ctor = Helper.getDeclaredConstructor(Store, int.class, String.class, String.class, String.class);
        date = Helper.getDeclaredField(Store, "date");
        REGEX_NAME  = Helper.getDeclaredField(Store, "REGEX_NAME");
        REGEX_PHONE = Helper.getDeclaredField(Store, "REGEX_PHONE");
        validate = Helper.getDeclaredMethod(Store, "validate");
    }

    @Override
    protected void scenario() {
        assumeModifier(ReflectorModifier.PUBLIC, validate);
        assumeModifier(ReflectorModifier.PUBLIC, REGEX_NAME);
        assumeModifier(ReflectorModifier.STATIC, REGEX_NAME);
        assumeModifier(ReflectorModifier.FINAL, REGEX_NAME);
        assumeModifier(ReflectorModifier.PUBLIC, REGEX_PHONE);
        assumeModifier(ReflectorModifier.STATIC, REGEX_PHONE);
        assumeModifier(ReflectorModifier.FINAL, REGEX_PHONE);
        assumeEquals(boolean.class, () -> validate.getReturnType());
        
        Object temp = null;
        try { temp = ctor.newInstance(1, "", "", ""); }
        catch (Throwable ignored) {}
        
        final Object instance = temp;
        
        Pattern tempPName  = null;
        Pattern tempPPhone = null;  
        try
        {
        	tempPName = Pattern.compile((String) REGEX_NAME.get(instance));
        	tempPPhone = Pattern.compile((String) REGEX_PHONE.get(instance));
        } catch (Throwable ignored) {}
        
        final Pattern ptName = tempPName;
        final Pattern ptPhone = tempPPhone;
        
        BiConsumer<Boolean, String> assumeNameRegex = (b, s) -> {
        	final String msg = String.format("Regex, Name: %s", s);
        	if (b) assumeTrue(msg, () -> ptName.matcher(s).find());
        	else assumeFalse(msg, () -> ptName.matcher(s).find());
        };
        
        BiConsumer<Boolean, String> assumePhoneRegex = (b, s) -> {
        	final String msg = String.format("Regex, Phone: %s", s);
        	if (b) assumeTrue(msg, () -> ptPhone.matcher(s).find());
        	else assumeFalse(msg, () -> ptPhone.matcher(s).find());
        };
        
        assumeNameRegex.accept(true, "Toko Sinary Jaya");
        assumeNameRegex.accept(true, "Tokosinarjayajuara123");
        
        assumeNameRegex.accept(false, "toko Sinar Jaya");
        assumeNameRegex.accept(false, "Toko");
        assumeNameRegex.accept(false, "123 Toko Sinar Jaya");
        assumeNameRegex.accept(false, "Toko Sinar Jaya Luar Biasa");
        assumeNameRegex.accept(false, "Toko Sinar  Jaya");
        
        assumePhoneRegex.accept(true, "081234567890");
        assumePhoneRegex.accept(true, "081234567");
        assumePhoneRegex.accept(true, "6285612345");
        
        assumePhoneRegex.accept(false, "abcdefghijkl");
        assumePhoneRegex.accept(false, "08121234");
        assumePhoneRegex.accept(false, "0812123456789");
        assumePhoneRegex.accept(false, "+6281-124-567");
        assumePhoneRegex.accept(false, "021abc45678");
    }

}
