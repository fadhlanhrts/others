package fazaJmartFH;

public class Pair<T, U>
{
    T first;
    U second;

    public Pair()
    {
        first = null;
        second = null;
    }

    public Pair(T first, U second)
    {
        this.first = first;
        this.second = second;
    }
}