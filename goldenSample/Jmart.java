package goldenSample;

import goldenSample.Transaction.*;
import com.google.gson.*;
/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class Jmart
{
    public static void main (String[] args)
    {
        Payment p = new Payment(
            0,
            1,
            2,
            3,
            new ShipmentDuration(ShipmentDuration.INSTANT, ShipmentDuration.REGULER)
        );

        Gson gson = new Gson();
        System.out.println(gson.toJson(p));
    }
}