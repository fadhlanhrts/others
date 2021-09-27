package goldenSample;

public class Complaint extends Recognizable implements FileParser
{
    public final String date;
    public String desc;

    public Complaint(int id, String desc)
    {
        super(id);
        this.desc = desc;
        date = "Date";
    }

    @Override
    public boolean read(String content) {
        // TODO Auto-generated method stub
        return false;
    }
}