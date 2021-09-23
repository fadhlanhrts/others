package goldenSample;

public class Recognizable
{
    public final int id;
    protected Recognizable(int id) { this.id = id; }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof Recognizable && ((Recognizable) other).id == id;
    }
    public boolean equals(Recognizable other)
    {
        return other.id == id;
    }
}