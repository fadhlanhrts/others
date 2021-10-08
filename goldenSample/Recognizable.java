package goldenSample;

public class Recognizable implements Comparable<Recognizable>
{
    public final int id;

    protected Recognizable(int id)
    {
        this.id = id;
    }

    public static <T extends Recognizable> int setClosingId(Class<T> clazz, int id)
    {
        return 0;
    }
    public static <T extends Recognizable> int getClosingId(Class<T> clazz)
    {
    	return 0;
    }
    public boolean equals(Object other)
    {
        return other instanceof Recognizable && ((Recognizable) other).id == id;
    }
    public boolean equals(Recognizable other)
    {
        return other.id == id;
    }

    @Override
    public int compareTo(Recognizable other)
    {
        return Integer.compare(this.id, other.id);
    }
}