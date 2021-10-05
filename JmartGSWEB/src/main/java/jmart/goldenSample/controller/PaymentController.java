package jmart.goldenSample.controller;

import jmart.goldenSample.*;
import jmart.goldenSample.dataset.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>
{
    public static JSONTable<Payment> table;

    public PaymentController()
    {
        try {
            table = JSONTable.createFromFile(Payment.class, "payment.json");
            final Payment objectMaxId = Algorithm.max(table.table);
            if (objectMaxId != null)
                Serializable.setClosingId(Payment.class, objectMaxId.id);
        }
        catch (Throwable throwable) { System.err.println(throwable); }
    }

    @Override
    public JSONTable<Payment> getJSONTable() {
        return table;
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public boolean create()
    {
        table.table.add(new Payment(0,0,0,new Shipment("a", 0, Shipment.Duration.INSTANT, "b")));
        try { table.write(); }
        catch (Throwable throwable) { throwable.printStackTrace(); }
        return true;
    }
}
