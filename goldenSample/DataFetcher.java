package goldenSample;

public class DataFetcher<T extends Recognizable>
{
    public final int objectPerPageCount;
    private int currentPage;
    private T[] buffer;

    @SuppressWarnings("unchecked")
    protected DataFetcher(int objectPerPageCount)
    { 
        this.currentPage = -1;
        this.objectPerPageCount = objectPerPageCount;
        this.buffer = (T[]) new Object[objectPerPageCount];
    }

    public T[] getPage(int page)
    {
        if (currentPage != page) // baca dari file
        {
            currentPage = page;
        }
        return buffer;
    }

    public T getById(int id)
    {
        for (T e : buffer)
            if (e.id == id)
                return e;
        return null;
    }    
}
