package AidanAzkafaroDesonJmartFH;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;


/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Recognizable
{
    // instance variables - replace the example below with your own
    public String desc;
    public String date;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Calendar cal = Calendar.getInstance();
    
    public Complaint(int id, String desc){
      
        this.desc = desc;
        this.date = sdf.format(cal.getTime());
    }
    public boolean validate(){
        return false;
    }
    
    public boolean read (String content){
        return false;
    }
    
    public String toString(){
        SimpleDateFormat SDformat = new SimpleDateFormat("dd/MM/yyyy");
        String formatDate = SDformat.format(cal.getTime());
        return "{date = " + formatDate + ", desc = '" + this.desc + "'}"; 
    }
    
}
