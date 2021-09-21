package unithelper;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import com.Reflector.ClassR;

public class Helper
{
    @FunctionalInterface
    public interface Noreturn { void run() throws Throwable; }

    public static boolean makeAccessible = false;

    public static Throwable suppress(Noreturn runnable)
    {
        try { runnable.run(); }
        catch (Throwable throwable) { return throwable; }
        return null;
    }
    public static void setAccessible(AccessibleObject object)
    {
        if (object != null)
            object.setAccessible(true);
    }
    public static Field getDeclaredField(ClassR classR, String name)
    {
        Field field = classR.getDeclaredField(name);
        if (makeAccessible && field != null)
            field.setAccessible(true);
        return field;
    }
    public static Constructor<?> getDeclaredConstructor(ClassR classR, Class<?>... args)
    {
        Constructor<?> ctor = classR.getDeclaredConstructor(args);
        if (makeAccessible && ctor != null)
            ctor.setAccessible(true);
        return ctor;
    }
    public static Method getDeclaredMethod(ClassR classR, String name, Class<?>... args)
    {
        Method method = classR.getDeclaredMethod(name, args);
        if (makeAccessible && method != null)
            method.setAccessible(true);
        return method;
    }
}
