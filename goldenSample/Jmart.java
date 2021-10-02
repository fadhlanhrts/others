package goldenSample;

import java.text.SimpleDateFormat;
import java.util.Date;

import goldenSample.Shipment.Duration;

/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class Jmart {
    public static void main(String[] args) {
    	System.out.println(Shipment.Duration.KARGO.getEstimatedArrival(new Date()));
    }
}