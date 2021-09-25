package goldenSample;

public class ProductRating implements FileParser
{
    private long total;
    private long count;

    public ProductRating()
    {
        total = 0;
        count = 0;
    }
    public void insert(int rating)
    {
        total += rating;
        ++count;
    }
    public double getAverage()
    {
        if (count == 0) return 0.0;
        return (double) total / count;
    }
    public long getCount()
    {
        return count;
    }
    public long getTotal()
    {
        return total;
    }

    @Override
    public boolean read(String content) {
        // TODO Auto-generated method stub
        return false;
    }
}
