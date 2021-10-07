package modul4CSUT;

import com.Reflector.ClassR;
import com.Reflector.MonoPackageTester;
import com.Reflector.ReflectorModifier;

import unithelper.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.BiConsumer;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ShipmentTest extends ExtendedRUT implements MonoPackageTester<ShipmentTest> {
    ClassR Shipment;
    ClassR Duration, MultiDuration;
    Constructor<?> ctor;
    Field address, shipmentCost, duration, receipt, ESTIMATION_FORMAT;
    Method getEstimatedArrival, format;
    Calendar cal = Calendar.getInstance();
    // SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("E MMMM dd yyyy");

    @Override
    public ShipmentTest newInstance() {
        return new ShipmentTest();
    }

    @Override
    public void obtainPackage(String s)
    {
        Helper.makeAccessible = true;
        Shipment = new ClassR(s, "Shipment");
        Duration = new ClassR(s, "Shipment$Duration");
        MultiDuration = new ClassR(s, "Shipment$MultiDuration");
        ctor = Helper.getDeclaredConstructor(Shipment, String.class, int.class, Duration.getContainingClass(),
                String.class);
        address = Helper.getDeclaredField(Shipment, "address");
        shipmentCost = Helper.getDeclaredField(Shipment, "shipmentCost");
        duration = Helper.getDeclaredField(Shipment, "duration");
        receipt = Helper.getDeclaredField(Shipment, "receipt");
        getEstimatedArrival = Helper.getDeclaredMethod(Duration, "getEstimatedArrival", Date.class);
        ESTIMATION_FORMAT = Helper.getDeclaredField(Duration, "ESTIMATION_FORMAT");
        format = new ClassR("java.text.SimpleDateFormat").getMethod("format", Date.class);
    }

    @Override
    protected void scenario() {
        cal.add(Calendar.DATE, 1);
        assumeModifier(ReflectorModifier.PUBLIC, getEstimatedArrival);
        assumeType(SimpleDateFormat.class, ESTIMATION_FORMAT);
        assumeReturnType(String.class, getEstimatedArrival);

        ClassR SDF = new ClassR("java.text.SimpleDateFormat");
        Method format = SDF.getMethod("format", Date.class);
        
        // E mmmm dd yyyy

        // just in case if not static
        Object temp = null;
        try { temp = ESTIMATION_FORMAT.get(Duration.getBypassInstantiation()); }
        catch (Throwable ignored) {}

        final Object estformatObj = temp;

        Consumer<String> assumeContains = (e) -> {
            assumeTrue(() -> {
                String res = (String) format.invoke(estformatObj, new Date());
                String only = new SimpleDateFormat(e).format(new Date());
                return res.contains(only);
            });
        };
        assumeContains.accept("E");
        assumeContains.accept("MMMM");
        assumeContains.accept("dd");
        assumeContains.accept("yyyy");
        
        // <nama field, estimasi hari dari sekarang>
        BiConsumer<String, Integer> assumeForwardEstimation = (f, d) -> {
            assumeTrue(f + " should estimate " + d + " days from now", () -> {
                Field field = Helper.getDeclaredField(Duration, f);
                Object obj = field.get(null);
                Date currentDate = new Date();

                Calendar cal = Calendar.getInstance();
                cal.setTime(currentDate);
                cal.add(Calendar.DATE, d);

                String ret1 = (String) getEstimatedArrival.invoke(obj, currentDate);
                String ret2 = (String) format.invoke(ESTIMATION_FORMAT.get(estformatObj), cal.getTime());
                return ret1.equals(ret2);
            });
        };

        assumeForwardEstimation.accept("INSTANT", 0);
        assumeForwardEstimation.accept("SAME_DAY", 0);
        assumeForwardEstimation.accept("NEXT_DAY", 1);
        assumeForwardEstimation.accept("REGULER", 2);
        assumeForwardEstimation.accept("KARGO", 5);
    }

}
