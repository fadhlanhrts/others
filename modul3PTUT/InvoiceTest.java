package modul3PTUT;

import com.Reflector.ClassR;
import com.Reflector.MonoPackageTester;
import com.Reflector.ReflectorModifier;
import com.Reflector.ReflectorUnitTest;
import unithelper.ExtendedRUT;
import unithelper.Helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class InvoiceTest extends ExtendedRUT implements MonoPackageTester<InvoiceTest>
{
    ClassR Invoice;
    ClassR Status, Rating;
    Constructor<?> ctor;
    Method getTotalPay;
    Field date, buyerId, productId, complaintId, rating, status;

    @Override
    protected void scenario() {
        assumeModifier(ReflectorModifier.PROTECTED, ctor);
        assumeModifier(ReflectorModifier.PUBLIC, getTotalPay);
        assumeModifier(ReflectorModifier.ABSTRACT, getTotalPay);
        assumeModifier(ReflectorModifier.PUBLIC, date);
        assumeModifier(ReflectorModifier.PUBLIC, buyerId);
        assumeModifier(ReflectorModifier.PUBLIC, productId);
        assumeModifier(ReflectorModifier.PUBLIC, complaintId);
        assumeModifier(ReflectorModifier.PUBLIC, rating);
        assumeModifier(ReflectorModifier.PUBLIC, status);

        assumeEquals("Recognizable", () -> Invoice.getContainingClass().getSuperclass().getSimpleName());
        assumeEquals("FileParser", () -> Invoice.getContainingClass().getInterfaces()[0].getSimpleName());

        assumeType(String.class, date);
        assumeType(int.class, buyerId);
        assumeType(int.class, productId);
        assumeType(int.class, complaintId);
        assumeType(Rating.getContainingClass(), rating);
        assumeType(Status.getContainingClass(), status);

        assumeEnumMember(
                Status,
                "WAITING_CONFIRMATION",
                "CANCELLED",
                "ON_PROGRESS",
                "ON_DELIVERY",
                "COMPLAINT",
                "FINISHED",
                "FAILED"
        );

        assumeEnumMember(
                Rating,
                "NONE",
                "BAD",
                "NEUTRAL",
                "GOOD"
        );
    }

    @Override
    public InvoiceTest newInstance() {
        return new InvoiceTest();
    }

    @Override
    public void obtainPackage(String s) {
        Helper.makeAccessible = true;
        Invoice = new ClassR(s, "Invoice");
        Status = new ClassR(s, "Invoice$Status");
        if (Status.getContainingClass() == null)
            Status = new ClassR(s, "Status");
        Rating = new ClassR(s, "Invoice$Rating");
        if (Rating.getContainingClass() == null)
            Rating = new ClassR(s, "Rating");
        ctor = Helper.getDeclaredConstructor(Invoice, int.class, int.class, int.class);
        getTotalPay = Helper.getDeclaredMethod(Invoice, "getTotalPay");
        date = Helper.getDeclaredField(Invoice, "date");
        buyerId = Helper.getDeclaredField(Invoice, "buyerId");
        productId = Helper.getDeclaredField(Invoice, "productId");
        complaintId = Helper.getDeclaredField(Invoice, "complaintId");
        rating = Helper.getDeclaredField(Invoice, "rating");
        status = Helper.getDeclaredField(Invoice, "status");
    }
}