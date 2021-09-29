package modul3PTUT;

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

public class ShipmentTest extends ExtendedRUT implements MonoPackageTester<ShipmentTest>
{
    ClassR Shipment;
    ClassR Duration, MultiDuration;
    Constructor<?> ctor;
    Field address, shipmentCost, duration, receipt;

    @Override
    protected void scenario() {
        assumeModifier(ReflectorModifier.PUBLIC, address);
        assumeModifier(ReflectorModifier.PUBLIC, shipmentCost);
        assumeModifier(ReflectorModifier.PUBLIC, duration);
        assumeModifier(ReflectorModifier.PUBLIC, receipt);
        assumeModifier(ReflectorModifier.PUBLIC, ctor);

        assumeEquals("FileParser", () -> Shipment.getContainingClass().getInterfaces()[0].getSimpleName());

        assumeNotNull(() -> Duration.getContainingClass());
        assumeNotNull(() -> MultiDuration.getContainingClass());

        assumeType(String.class, address);
        assumeType(int.class, shipmentCost);
        assumeType(Duration.getContainingClass(), duration);
        assumeType(String.class, receipt);

        assumeEquals(byte.class, () -> Duration.getDeclaredField("bit").getType());
        assumeEquals(byte.class, () -> MultiDuration.getDeclaredField("bit").getType());

        Object temp = null;
        try { temp = ctor.newInstance("papua", 2, null, "RAs2sdfa"); }
        catch (Throwable ignored) {}

        final Object obj = temp;
        assumeEquals("papua", () -> address.get(obj));
        assumeEquals(2, () -> shipmentCost.get(obj));
        assumeEquals("RAs2sdfa", () -> receipt.get(obj));
    }

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
        ctor = Helper.getDeclaredConstructor(Shipment, String.class, int.class, Duration.getContainingClass(), String.class);
        address = Helper.getDeclaredField(Shipment, "address");
        shipmentCost = Helper.getDeclaredField(Shipment, "shipmentCost");
        duration = Helper.getDeclaredField(Shipment, "duration");
        receipt = Helper.getDeclaredField(Shipment, "receipt");
    }
}

