package MuhammadRaihanAzhariJmartFH;

import java.text.*;
import java.util.Calendar;
import java.util.Date;


/**
 * Write a description of class Shipment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Shipment
{
    public String address;
    public int shipmentCost;
    public Plan plan;
    public String receipt;
    
    // instance variables - replace the example below with your own
    public static final Plan INSTANT = new Plan((byte)(1<<0));
    public static final Plan SAME_DAY = new Plan((byte)(1<<1));
    public static final Plan NEXT_DAY = new Plan((byte) (1<<2));
    public static final Plan REGULER = new Plan((byte)(1<<3));
    public static final Plan KARGO = new Plan((byte)(1<<4));
    public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("E MMMM dd yyyy");
    
    
    
    public static class Plan
    {
 
    public byte bit;
    
    private Plan(byte bit){
        this.bit = bit;
    	}
    }
    
    public String getEstimatedArrival(Date reference){
      Calendar newDate = Calendar.getInstance();
      if(plan.bit == (1<<0)){
          return ESTIMATION_FORMAT.format(reference.getTime());
      }
      else if(plan.bit == (1<<1)){
          return ESTIMATION_FORMAT.format(reference.getTime());
      }
      else if (plan.bit == (1<<2)){
          newDate.setTime(reference);
          newDate.add(Calendar.DATE, 1);
          return ESTIMATION_FORMAT.format(newDate.getTime());
      }
      else if (plan.bit == (1<<3)){
          newDate.setTime(reference);
          newDate.add(Calendar.DATE, 2);
          return ESTIMATION_FORMAT.format(newDate.getTime());
      }
      else{
          newDate.setTime(reference);
          newDate.add(Calendar.DATE, 5);
          return ESTIMATION_FORMAT.format(newDate.getTime());
      }
   }
        
    
    
 
        
        public void isDuration (Plan... args){
            for(Plan i: args){
                plan.bit |= i.bit;
            }
        }
        public boolean isDuration(Plan reference){
            if((plan.bit & reference.bit) == reference.bit){
                return true;
            }
            else{
                return false;
            }
        }
        
    
    
    public Shipment(String address, int shipmentCost, byte plan2, String receipt){
        this.address = address;
        this.shipmentCost = shipmentCost;
        plan.bit = plan2;
        this.receipt = receipt;
    }
    
  
}
