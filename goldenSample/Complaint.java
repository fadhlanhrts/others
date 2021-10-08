package goldenSample;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Complaint extends Recognizable implements FileParser {
    public final Date date;
    public String desc;

    public Complaint(int id, String desc) {
        super(id);
        this.desc = desc;
        this.date = new Date();
    }

    @Override
    public boolean read(String content) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(date);
        return "Complaint{" + "date=" + strDate + ", desc='" + desc + '\'' + '}';
    }
}