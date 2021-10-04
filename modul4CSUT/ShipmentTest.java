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
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ShipmentTest extends ExtendedRUT implements MonoPackageTester<ShipmentTest> {
    ClassR Shipment;
    ClassR Duration, MultiDuration;
    Constructor<?> ctor;
    Field address, shipmentCost, duration, receipt, ESTIMATION_FORMAT;
    Method getEstimatedArrival;
    Calendar cal = Calendar.getInstance();
    // SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("E MMMM dd yyyy");

    @Override
    public ShipmentTest newInstance() {
        return new ShipmentTest();
    }

    @Override
    public void obtainPackage(String s) {
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
    }

}
