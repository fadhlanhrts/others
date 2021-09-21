package modul2PTUT;

import com.Reflector.*;
import unithelper.*;
import java.lang.reflect.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class ShipmentDurationTest extends ReflectorUnitTest implements MonoPackageTester<ShipmentDurationTest>
{
    ClassR ShipmentDuration;
    
    Field INSTANT, SAME_DAY, NEXT_DAY, REGULER, KARGO;
    Field bit;

    Constructor<?> ctor1;
    Constructor<?> ctor2;

    Method isDuration;

    @Override
    public ShipmentDurationTest newInstance()
    {
        return new ShipmentDurationTest();
    }

    @Override
    public void obtainPackage(String arg0)
    {
        Helper.makeAccessible = true;
        ShipmentDuration = new ClassR(arg0, "ShipmentDuration");
        INSTANT  = Helper.getDeclaredField(ShipmentDuration, "INSTANT");
        SAME_DAY = Helper.getDeclaredField(ShipmentDuration, "SAME_DAY");
        NEXT_DAY = Helper.getDeclaredField(ShipmentDuration, "NEXT_DAY");
        REGULER  = Helper.getDeclaredField(ShipmentDuration, "REGULER");
        KARGO    = Helper.getDeclaredField(ShipmentDuration, "KARGO");
        bit      = Helper.getDeclaredField(ShipmentDuration, "bit");
        
        Class<?> clazz = ShipmentDuration.getContainingClass();
        ctor1    = Helper.getDeclaredConstructor(ShipmentDuration, int.class);
        ctor2    = clazz == null ? null : Helper.getDeclaredConstructor(ShipmentDuration, Array.newInstance(clazz, 0).getClass());
    
        isDuration = clazz == null ? null : Helper.getDeclaredMethod(ShipmentDuration, "isDuration", clazz);
    }

    @Override
    protected void scenario()
    {
        Class<?> clazz = ShipmentDuration.getContainingClass();

        Consumer<Field> assumePublicConstant = (f) -> {
            assumeModifier(ReflectorModifier.PUBLIC, f);
            assumeModifier(ReflectorModifier.STATIC, f);
            assumeModifier(ReflectorModifier.FINAL, f);
        };

        assumePublicConstant.accept(INSTANT);
        assumePublicConstant.accept(SAME_DAY);
        assumePublicConstant.accept(NEXT_DAY);
        assumePublicConstant.accept(REGULER);
        assumePublicConstant.accept(KARGO);

        assumeModifier(ReflectorModifier.PRIVATE, bit);
        assumeModifier(ReflectorModifier.FINAL, bit);

        BiConsumer<Field, Integer> assumeBitValue = (f, i) -> {
            assumeTrue(() -> {
                // just in case if it's not static
                Object instance = ShipmentDuration.getBypassInstantiation();
                Object o = f.get(instance);
                return this.bit.getInt(o) == i;
            });
        };

        assumeBitValue.accept(INSTANT,  1 << 0);
        assumeBitValue.accept(SAME_DAY, 1 << 1);
        assumeBitValue.accept(NEXT_DAY, 1 << 2);
        assumeBitValue.accept(REGULER,  1 << 3);
        assumeBitValue.accept(KARGO,    1 << 4);

        // ctor 1 test assign bit
        assumeEquals(1, () -> {
            Object instance = ctor1.newInstance(1);
            return bit.get(instance);
        });

        assumeEquals(2, () -> {
            Object instance = ctor1.newInstance(2);
            return bit.get(instance);
        });

        // ctor 2 test varargs flags
        assumeTrue(() -> {
            return ctor2.isVarArgs();
        });

        assumeEquals(1, () -> {
            Object instance[] = (Object[]) Array.newInstance(clazz, 1);
            instance[0] = ShipmentDuration.getBypassInstantiation();
            bit.set(instance[0], 1);
            Object obj = ctor2.newInstance((Object) instance);
            return bit.get(obj);
        });

        assumeBitAssignment(1, 1 << 0);
        assumeBitAssignment(3, 1 << 0, 1 << 1);
        assumeBitAssignment(7, 1 << 0, 1 << 1, 1 << 2);
        assumeBitAssignment(19, 1 << 0, 1 << 1, 1 << 4);

        Function<Integer, Object> getSD = (i) -> {
            try {
                Object temp = ShipmentDuration.getBypassInstantiation();
                bit.set(temp, i);
                return temp;
            } catch (Throwable ignored) { return null; }
        };

        final Object instance = getSD.apply(25);
        assumeEquals(true,  () -> isDuration.invoke(instance, getSD.apply(1 << 0)));
        assumeEquals(false, () -> isDuration.invoke(instance, getSD.apply(1 << 1)));
        assumeEquals(false, () -> isDuration.invoke(instance, getSD.apply(1 << 2)));
        assumeEquals(true,  () -> isDuration.invoke(instance, getSD.apply(1 << 3)));
        assumeEquals(true,  () -> isDuration.invoke(instance, getSD.apply(1 << 4)));
    }

    private void assumeBitAssignment(int bit, int... args)
    {
        assumeEquals(bit, () -> 
        {
            final Object instance[] = (Object[]) Array.newInstance(ShipmentDuration.getContainingClass(), args.length);
            for (int i = 0; i < args.length; ++i)
            {
                instance[i] = ShipmentDuration.getBypassInstantiation();
                this.bit.set(instance[i], args[i]);
            }
            final Object obj = ctor2.newInstance((Object) instance);
            return this.bit.get(obj);
        });
    }
}
