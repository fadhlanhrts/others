package valentinusJmartFH;

import java.util.Iterator;
import java.util.*;

public class Algorithm {
	private Algorithm() {

	}

	public static <T> int count(T[] array, T value) {
		final Iterator<T> counter = Arrays.stream(array).iterator();
		return count(counter, value);
	}

	public static <T> int count(Iterable<T> iterable, T value) {
		final Iterator<T> counter = iterable.iterator();
		return count(counter, value);
	}

	public static <T> int count(Iterator<T> iterator, T value) {
		final Predicate<T> pred = value::equals;
		return count(iterator, pred);
	}

	public static <T> int count(T[] array, Predicate<T> pred) {
		final Iterator<T> counter = Arrays.stream(array).iterator();
		return count(counter, pred);
	}

	public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
		final Iterator<T> counter = iterable.iterator();
		return count(counter, pred);
	}

	public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
		return count(iterator, pred);
	}

	public static <T> boolean exists(T[] array, T value) {
		final Iterator<T> counter = Arrays.stream(array).iterator();
		return exists(counter, value);
	}

	public static <T> boolean exists(Iterable<T> iterable, T value) {
		final Iterator<T> counter = iterable.iterator();
		return exists(counter, value);
	}

	public static <T> boolean exists(Iterator<T> iterator, T value) {
		final Predicate<T> pred = value::equals;
		return exists(iterator, pred);
	}

	public static <T> boolean exists(T[] array, Predicate<T> pred) {
		final Iterator<T> counter = Arrays.stream(array).iterator();
		return exists(counter, pred);
	}

	public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
		final Iterator<T> counter = iterable.iterator();
		return exists(counter, pred);
	}

	public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
		return exists(iterator, pred);
	}

	public static <T> T find(T[] array, T value) {
		final Iterator<T> counter = Arrays.stream(array).iterator();
		return find(counter, value);
	}

	public static <T> T find(Iterable<T> iterable, T value) {
		final Iterator<T> counter = iterable.iterator();
		return find(counter, value);
	}

	public static <T> T find(Iterator<T> iterator, T value) {
		final Predicate <T> pred = value ::equals;
        return find(iterator, pred);
	}

	public static <T> T find(T[] array, Predicate<T> pred) {
		for (T a : array) {
			if (a.equals(pred)) {
				return a;
			}
		}
		return null;
	}

	public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
		return find(iterable.iterator(), pred);
	}

	public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
		return find(iterator, pred);
	}

	public <T extends Comparable<? super T>> T max(T first, T second) {
	     if(first.compareTo(second) > 0) {
	        return first;
	     } else {
	        return second;
	     }
	  }

	public static <T> T max(T first, T second)
    {
        if(first.hashCode()>second.hashCode())
        {
            return first;
        }else
        {
            return second;
        }
    }

    public static <T> T max(T[] array)
    {
        int max = 0;
        T maxT = null;
        for (T t : array)
        {
            if (t.hashCode() > max)
            {
                max = t.hashCode();
                maxT = t;
            }
        }
        return maxT;
    }

    public static <T> T max(Iterator<T>iterator, T value)
    {
        if(iterator.next().hashCode()>value.hashCode())
        {
            return iterator.next();
        } else
        {
            return value;
        }
    }
    
    public static <T> T max(Iterable<T>iterable, T value)
    {
        if(iterable.hashCode()>value.hashCode()){
            return (T) iterable;
        } else
        {
            return value;
        }
    }
    public static <T> T max(T first, T second, Comparator<?super T>comparator)
    {
        int res = ((Comparable<T>) first).compareTo(second);
        return res == -1 ? second : first;
    }
    
    public static <T> T max(Iterator<T>iterator, T value, Comparator<?super T>comparator)
    {
        int res = ((Comparable<T>) iterator).compareTo(value);
        if(iterator.next().hashCode()>value.hashCode())
        {
            return iterator.next();
        } else
        {
            return value;
        }
    }
    
    public static <T> T max(T[] array, Comparator<?super T>comparator)
    {
        int max = 0;
        T maxT = null;
        for (T t : array)
        {
            if (t.hashCode() > max)
            {
                max = t.hashCode();
                maxT = t;
            }
        }
        int res = ((Comparable<T>) comparator).compareTo((T) array);
        return max(array, comparator);
    }

    public static <T extends Comparable<? super T>> T min(T first, T second) {
        if(first.compareTo(second)<0){
            return first;
        }else{
            return second;
        }
    }

    public static <T extends Comparable<? super T>> T min(T[] array) {
        int minn = 0;
        T min = null;
        for (T t : array) {
            if (t.hashCode() < minn) {
                minn = t.hashCode();
                min = t;
            }
        }
        return min;
    }

    public static <T extends Comparable<? super T>> T min(Iterable<T>iterable){
        Iterator<T> iterator = iterable.iterator();
        int minn = 0;
        T min = null;
        if (iterator.hashCode() > minn){
            minn = iterator.hashCode();
            min = (T) iterator;
        }
        return min;
    }

    public static <T extends Comparable<? super T>> T min(Iterator<T>iterator) {
        int minn = 0;
        T min = null;
        while(iterator.hasNext()){
            if(iterator.next().hashCode() > minn){
                minn = iterator.next().hashCode();
                min = (T) iterator;
            }
        }
        return min;
    }

    public static <T extends Comparable<?super T>> T min (T first, T second, Comparator<? super T>comparator){
        int res = ((Comparable<T>) first).compareTo(second);
        return res == -1 ? second : first;
    }

       /*public static <T extends Comparable<?super T>> T min (T[]array, Comparator<? super T>comparator){
        
    }*/

    /*public static <T extends Comparable<?super T>> T min(Iterabale<T> iterable, Comparator<? super T> comparator){

    }/*

    /*public static <T extends Comparable<?super T>> T min(Iterator<T> iterator, Comparator<?super T> comparator){

    }*/
}
