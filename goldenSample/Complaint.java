package goldenSample;

public class Complaint implements FileParser
{

    public Invoice invoice;
    public String desc;

    public Complaint(Invoice invoice,String desc)
    {
        this.invoice = invoice;
        this.desc = desc;
    }

    @Override
    public boolean read(String content) {
        // TODO Auto-generated method stub
        return false;
    }
}