package valentinusJmartFH;

public abstract class Recognizable implements Comparable <Recognizable>
{
    public final int id;
    
    protected Recognizable(int id)
    {
        this.id = id;
    }
    
    public static <T> int setClosingId(Class<T> clazz, int id) 
    {
        if (Class.class.isAssignableFrom(Recognizable.class)) {
            return 0;
        } 
        else return 1;
    }

    public static <T> int getClosingId(Class<T> clazz) 
    {
        if (Class.class.isAssignableFrom(Recognizable.class)) {
            return 0;
        } 
        else return 1;
    }
    
    public boolean equals(Object object)
    {
        return (object != null) && (object instanceof Recognizable) && (this.id == ((Recognizable) object).id);
    }
    
    public boolean equals(Recognizable recognizable)
    {
        if(this.id == recognizable.id) {
            return true;
        }
        return false;
    }
    
    @Override
    public int compareTo(Recognizable other) 
    {
        if (id == other.id) {
            return 1;
        }
        else return 0;
    }
}
