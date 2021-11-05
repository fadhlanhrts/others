package RionaldiJmartFH;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Recognizable
{
    public Date date;
    public String desc;
    
    public Complaint(int id, String desc)
    {

        this.desc = desc;
        this.date =new java.util.Date();
    }

    
    public String toString(){
        String format = "dd/MM/yyyy";
        SimpleDateFormat format1 = new SimpleDateFormat(format);
        return "Complaint{date=" + format1.format(this.date) + ",desc=" + "'" + this.desc + "'}";
    }
}
