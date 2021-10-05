package jmart.goldenSample.dataset;

public class Complaint extends Serializable
{
    public final String date;
    public String desc;

    public Complaint(String desc)
    {
        this.desc = desc;
        date = "Date";
    }
}