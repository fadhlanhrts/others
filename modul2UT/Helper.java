package modul2UT;

import java.lang.reflect.AccessibleObject;

public class Helper
{
    public static void setAccessible(AccessibleObject object)
    {
        if (object != null)
            object.setAccessible(true);
    }
}
