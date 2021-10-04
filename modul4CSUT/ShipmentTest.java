package modul4CSUT;

import com.Reflector.ClassR;
import com.Reflector.MonoPackageTester;
import com.Reflector.ReflectorModifier;
import com.Reflector.ReflectorUnitTest;
import modul3CSUT.RecognizableTest;
import unithelper.ExtendedRUT;
import unithelper.Helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
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

    }

}
