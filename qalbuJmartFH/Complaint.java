package qalbuJmartFH;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Complaint extends Recognizable implements FileParser {
    public final Date date;
    public String desc;
    
    public Complaint (int id, String desc) {
        super (id);
        this.desc = desc;
        date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd//MM//yy");
    }
    
    public boolean read (String content){
        return false;
    }
    public Object write (){
        return null;
    }
    public Object newInstance (String content){
        return null;
    }
    
    public String toString (){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formatDate = sdf.format(this.date);
        return "Complaint{date =" + formatDate + "desc = '" + this.desc + "'}";
    }
}