package valentinusJmartFH;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Complaint extends Recognizable implements FileParser
{
    public Date date;
    public String desc;
    public String kurir;
    
    public Complaint(int id, String desc)
    {
        super(id);
        this.desc = desc;
    }
    
    @Override
    public boolean read(String content) 
    {
        return false;
    }
    
    public String toString()
    {
        SimpleDateFormat tanggalComplaint = new SimpleDateFormat("dd/MM/yyyy");
        String tanggal = tanggalComplaint.format(this.date);
        
        return "{date = " + tanggal + "desc = '" + this.desc + "'}";
    }
}
