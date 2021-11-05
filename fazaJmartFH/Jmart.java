package fazaJmartFH;

public class Jmart
{
    public static void main (String[] args)
    {
        Complaint compl = new Complaint(33, "Kelamaan menunggu");
        System.out.println(compl.toString());
        
        Account tes = new Account(22, "Nabil", "nabilnabil@ooyeah.com", "aV2ddaaa2d");
        System.out.println(tes.validate());
        
    }
}
