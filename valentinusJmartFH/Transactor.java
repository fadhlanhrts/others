package valentinusJmartFH;

public interface Transactor
{
    public default Boolean validate() {
        return null;
    }
    
    public default Invoice perform()
    {
        return null;
    }
}
