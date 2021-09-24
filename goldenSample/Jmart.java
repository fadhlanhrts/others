package goldenSample;

import goldenSample.Transaction.*;
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
    }
}