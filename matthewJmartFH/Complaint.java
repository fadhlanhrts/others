package matthewJmartFH;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Recognizable implements FileParser
{
    // instance variables - replace the example below with your own
    public Date date  ;
    public String desc;
    /**
     * Constructor for objects of class Complaint
     */
    public Complaint(int id, String desc)
    {
        super(id);
        this.desc = desc;
        this.date = new Date();
    }
    
    public boolean read(String content)
    {
        return false;
    }
    
    public String toString()
    {   
        SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
        return "Complaint{date=" + date_format.format(this.date) + "," + "desc='"+this.desc+"'"+"}";
    }
}
