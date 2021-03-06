package modul4PTUT;

import com.NetlabUT.Executable;
import com.Reflector.ClassR;
import com.Reflector.MonoPackageTester;
import com.Reflector.ReflectorModifier;
import unithelper.ExtendedRUT;
import unithelper.Helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.function.BiConsumer;
import java.util.regex.Pattern;

public class AccountTest extends ExtendedRUT implements MonoPackageTester<AccountTest> {
    ClassR Account;
    Constructor<?> ctor;
    Method validate;
    Field REGEX_EMAIL, REGEX_PASSWORD;

    @Override
    protected void scenario() {
        assumeModifier("Tolong cek logika method validate scr manual karena tidak diuji",
        		ReflectorModifier.PUBLIC, validate);
        assumeReturnType(boolean.class, validate);
        
        assumeModifier(ReflectorModifier.PUBLIC, REGEX_EMAIL);
        assumeModifier(ReflectorModifier.STATIC, REGEX_EMAIL);
        assumeModifier(ReflectorModifier.FINAL, REGEX_EMAIL);
        assumeModifier(ReflectorModifier.PUBLIC, REGEX_PASSWORD);
        assumeModifier(ReflectorModifier.STATIC, REGEX_PASSWORD);
        assumeModifier(ReflectorModifier.FINAL, REGEX_PASSWORD);
        
        Object temp = null;
        try { temp = ctor.newInstance(1, "", "", ""); }
        catch (Throwable ignored) {}
        
        final Object account = temp;
        
        BiConsumer<Boolean, String> assumeRegexEmail = (b, s) -> {
        	BiConsumer<String, Executable> f = this::assumeTrue;
        	if (!b) f = this::assumeFalse;
        	Executable exec = () -> {
        		String strRegex = (String) REGEX_EMAIL.get(account);
        		return Pattern.compile(strRegex).matcher(s).matches();
        	};
        	f.accept("Regex, Email:" + s, exec);
        };
        BiConsumer<Boolean, String> assumeRegexPassword = (b, s) -> {
        	BiConsumer<String, Executable> f = this::assumeTrue;
        	if (!b) f = this::assumeFalse;
        	Executable exec = () -> {
        		String strRegex = (String) REGEX_PASSWORD.get(account);
        		return Pattern.compile(strRegex).matcher(s).matches();
        	};
        	f.accept("Regex, Password:" + s, exec);
        };
        
        assumeRegexEmail.accept(true, "jono.sukandar@ui.ac.id");
        assumeRegexEmail.accept(true, "jonosukandar123@gmail.com");
        assumeRegexEmail.accept(true, "jono.sukandar.123@ui.ac.id");
        assumeRegexEmail.accept(true, "jono.sukandar@telkom.univ.com");
        assumeRegexEmail.accept(true, "philjackson@ui.ac.id");
        assumeRegexEmail.accept(true, "jono.&~sukandar@ui.ac.id");
        assumeRegexEmail.accept(true, "jono.*sukandar@ui.ac.id");
        assumeRegexEmail.accept(true, "jono.&sukandar@ui.ac.id");
        assumeRegexEmail.accept(true, "jono&sukandar@ui.ac.id");
        assumeRegexEmail.accept(true, "jono~sukandar@ui.ac.id");
        assumeRegexEmail.accept(false, "jonosukandarui.ac.id");
        assumeRegexEmail.accept(false, "jonosukandarui..ac.id");
        assumeRegexEmail.accept(false, "jonosukandar@ui..ac.id");
        assumeRegexEmail.accept(false, "jono-sukandar@ui.ac.id");
        assumeRegexEmail.accept(false, "jono..sukandarui.ac.id");
        assumeRegexEmail.accept(false, ".jonosukandar@ui.ac.id");
        assumeRegexEmail.accept(false, "jonosukandar@.ui.ac.id");
        assumeRegexEmail.accept(false, "jonosukandar@ui.ac.id.");
        assumeRegexEmail.accept(false, "jonosukandar@ui-.ac.id");
        assumeRegexEmail.accept(false, "jonosukandar@ui&ac~id");

        assumeRegexPassword.accept(true, "Mantab123");
        assumeRegexPassword.accept(true, "Mantab$123");
        assumeRegexPassword.accept(true, "M4N%ab123");
        assumeRegexPassword.accept(true, "Ma1manma");
        assumeRegexPassword.accept(true, "M@nt@b123");
        assumeRegexPassword.accept(false, "mantab123");
        assumeRegexPassword.accept(false, "MANTAB123");
        assumeRegexPassword.accept(false, "12345678");
        assumeRegexPassword.accept(false, "Ma123");
        assumeRegexPassword.accept(false, "Man 12345");
    }

    @Override
    public AccountTest newInstance() {
        return new AccountTest();
    }

    @Override
    public void obtainPackage(String s)
    {
        Helper.makeAccessible = true;
        Account = new ClassR(s, "Account");
        ctor = Helper.getDeclaredConstructor(Account, int.class, String.class, String.class, String.class);
        validate = Helper.getDeclaredMethod(Account, "validate");
        REGEX_EMAIL = Helper.getDeclaredField(Account, "REGEX_EMAIL");
        REGEX_PASSWORD = Helper.getDeclaredField(Account, "REGEX_PASSWORD");
    }
}