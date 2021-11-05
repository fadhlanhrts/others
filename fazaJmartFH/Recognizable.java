package fazaJmartFH;
import java.lang.Integer;

public class Recognizable implements Comparable<Recognizable>
{
    public final int id;
    
    protected Recognizable()
    {
        this.id = 999;
    }

    @Override
    public int compareTo (Recognizable other)
    {
        if(id == other.id)
        {
            return 0;
        }
        else if (id > other.id)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

    public boolean equals(Object object)
    {
        if (object instanceof Recognizable)
        {
            Recognizable obj = (Recognizable)object;
            
            if(obj.id == id)
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean equals(Recognizable recognizable)
    {
        return recognizable.id == id;
    }

    public static <T> int setClosingId(Class<T> clazz, int id)
    {
        if(Class.class.isAssignableFrom(Recognizable.class))
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public static <T> int getClosingId(Class<T> clazz)
    {
        if(Class.class.isAssignableFrom(Recognizable.class))
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
