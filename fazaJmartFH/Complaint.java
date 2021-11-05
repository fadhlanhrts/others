package fazaJmartFH;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Complaint extends Recognizable
{ 
    public String desc;
    public final Date date;
    public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    
    public Complaint(int id, String desc)
    {
        this.desc = desc;
        this.date = new Date();
    }
    
    public String toString()
    {
        return "Complaint{date=" + ESTIMATION_FORMAT.format(date.getTime()) + ", desc='" + desc + "'}";
    }
}
