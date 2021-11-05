package RaihanJmartFH;
import java.util.Iterator;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class Algorithm {
    private Algorithm(){

    }


    public static <T> List<T> collect(T[] array , T value){
        final Iterator<T>it = Arrays.stream(array).iterator();
        return collect(it, value);
    }
    public static <T> List<T> collect(Iterable<T>iterable , T value){
        final Iterable<T>e = (Iterable<T>) iterable.iterator();
        return collect(e, value);
    }
    public static <T> List<T> collect(Iterator<T>iterator , T value){
        final Predicate<T> predicate = value::equals;
        return collect(iterator, value);
    }
    public static <T> List<T> collect(T[] array, Predicate<T> pred){
        final Iterator<T> itArray = Arrays.stream(array).iterator();
        return collect(itArray, pred);
    }
    public static <T> List<T> collect(Iterator<T>iterator, Predicate<T> pred){
        int count = 0;
        while(iterator.hasNext()){
            count++;
        }
        final Predicate<T> predicate = pred::equals;
        return collect(iterator, pred);
    }

    public static <T> int count(T[] array , T value){
        final Iterator<T>it = Arrays.stream(array).iterator();
        return count(it, value);
    }
    public static <T> int count(Iterable<T>iterable , T value){
        final Iterable<T>e = (Iterable<T>) iterable.iterator();
        return count(e, value);
    }
    public static <T> int count(Iterator<T>iterator , T value){
        final Predicate<T> predicate = value::equals;
        return count(iterator, value);
    }
    public static <T> int count(T[] array, Predicate<T> pred){
        final Iterator<T> itArray = Arrays.stream(array).iterator();
        return count(itArray, pred);
    }
    public static <T> int count(Iterable<T>iterable, Predicate<T> pred){
        final Iterable<T>e = (Iterable<T>) iterable.iterator();
        return count(e, pred);
    }
    public static <T> int count(Iterator<T>iterator, Predicate<T> pred){
        int count = 0;
        while(iterator.hasNext()){
            count++;
        }
        final Predicate<T> predicate = pred::equals;
        return count(iterator, pred);
    }


    public static <T> boolean exists(T[] array, T value){
        for (T a : array){
            if(a.equals(value)){
                return true;
            }
        }
        return false;
    }
    public static <T> boolean exists(Iterable<T> iterable, T value){
        for (T a : iterable){
            if(a.equals(value)){
                return true;
            }
        }
        return false;
    }
    public static <T> boolean exists(Iterator<T> iterator, T value){
        while (iterator.hasNext()){
            if (iterator.next().equals(value)){
                return true;
            }
        }
        return false;
    }
    public static <T> boolean exists(T[] array, Predicate<T> pred){
        for (T a : array){
            if(a.equals(pred)){
                return true;
            }
        }
        return false;
    }
    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred){
        for (T a : iterable){
            if(a.equals(pred)){
                return true;
            }
        }
        return false;
    }
    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred){
        while (iterator.hasNext()){
            if (iterator.next().equals(pred)){
                return true;
            }
        }
        return false;
    }

    public static <T> T find(T[] array, T value){
        for (T a : array){
            if(a.equals(value)){
                return a;
            }
        }
        return null;
    }
    public static <T> T find(Iterable<T> iterable, T value){
        for (T a : iterable){
            if(a.equals(value)){
                return a;
            }
        }
        return null;
    }
    public static <T> T find(Iterator<T> iterator, T value){
        while (iterator.hasNext()){
            if(iterator.next().equals(value)){
                return iterator.next();
            }
        }
        return null;
    }
    public static <T> T find(T[] array, Predicate<T> pred){
        for (T a : array){
            if(a.equals(pred)){
                return a;
            }
        }
        return null;
    }
    public static <T> T find(Iterable<T> iterable, Predicate<T> pred){
        for (T a : iterable){
            if(a.equals(pred)){
                return a;
            }
        }
        return null;
    }
    public static <T> T find(Iterator<T> iterator, Predicate<T> pred){
        while (iterator.hasNext()){
            if(iterator.next().equals(pred)){
                return iterator.next();
            }
        }
        return null;
    }

    public static <T extends Comparable<? super T>> T max(T first, T  second){
        T maximum;
        if(first.compareTo(second) >= 0){
            maximum = first;
        }
        else{
            maximum = second;
        }
        return maximum;
    }
    public static <T extends Comparable<? super T>> T max(T[] array){
        T maximum = null;
        for (T t : array) {
            if(t.compareTo(maximum) >= 0){
                maximum = t;
            }
            else{
                maximum = maximum;
            }
        }
        return maximum;
    }
    public static <T extends Comparable<? super T>> T max(Iterable<T> iterable){
        final Iterator <T> t  = iterable.iterator();
        T maximum = null;
        while(t.hasNext()){
            if (t.next().compareTo(maximum) >= 0){
                maximum = t.next();
            }
        }
        return maximum;
    }
    public static <T extends Comparable<? super T>> T max(Iterable<T> iterable, Comparator<? super T> comparator){
        final Iterator <T> t  = iterable.iterator();
        T maximum = null;
        while(t.hasNext()){
            if (comparator.compare(t.next(), maximum) >= 0){
                maximum = t.next();
            }
        }
        return maximum;
    }
    public static <T extends Comparable<? super T>> T max(T first, T  second, Comparator<? super T> comparator){
        T maximum;
        if(comparator.compare(first, second) >= 0){
            maximum = first;
        }
        else{
            maximum = second;
        }
        return maximum;
    }
    public static <T extends Comparable<? super T>> T max(T[] array, Comparator<? super T> comparator){
        T maximum = null;
        for (T t : array) {
            if(comparator.compare(t, maximum) >= 0){
                maximum = t;
            }
            else{
                maximum = maximum;
            }
        }
        return maximum;
    }
    public static <T extends Comparable<? super T>> T max(Iterator <T> iterator, Comparator<? super T> comparator){
        T maximum = null;
        while(iterator.hasNext()){
            if(comparator.compare(iterator.next(), maximum)>= 0){
            }
        }
        return maximum;
    }
    public static <T extends Comparable<? super T>> T max(Iterator <T> iterator){
        T maximum = null;
        while(iterator.hasNext()){
            if(iterator.next().compareTo(maximum) >= 0){
            }
        }
        return maximum;
    }


    public static <T extends Comparable<? super T>> T min(T  first, T  second){
        T minimum;
        if(first.compareTo(second) <= 0){
            minimum = first;
        }
        else{
            minimum = second;
        }
        return minimum;
    }
    public static <T extends Comparable<? super T>> T min(T[] array){
        T minimum = null;
        for (T t : array){
            if(t.compareTo(minimum) <= 0){
                minimum = t;
            }
            else{
                minimum = minimum;
            }
        }
        return minimum;
    }
    public static <T extends Comparable<? super T>> T min(Iterable<T> iterable){
        final Iterator <T> t  = iterable.iterator();
        T minimum = null;
        while(t.hasNext()){
            if (t.next().compareTo(minimum) <= 0){
                minimum = t.next();
            }
        }
        return minimum;
    }
    public static <T extends Comparable<? super T>> T min(Iterable<T> iterable, Comparator<? super T> comparator){
        final Iterator <T> t  = iterable.iterator();
        T minimum = null;
        while(t.hasNext()){
            if (comparator.compare(t.next(), minimum) <= 0){
                minimum = t.next();
            }
        }
        return minimum;
    }

    public static <T extends Comparable<? super T>> T min(T first, T  second, Comparator<? super T> comparator){
        T minimum;
        if(comparator.compare(first, second) >= 0){
            minimum = first;
        }
        else{
            minimum = second;
        }
        return minimum;
    }
    public static <T extends Comparable<? super T>> T min(T[] array, Comparator<? super T> comparator){
        T minimum = null;
        for (T t : array){
            if(comparator.compare(t, minimum) <= 0){
                minimum = t;
            }
            else{
                minimum = minimum;
            }
        }
        return minimum;
    }

    public static <T extends Comparable<? super T>> T min(Iterator <T> iterator, Comparator<? super T> comparator){
        T minimum = null;
        while(iterator.hasNext()){
            if(comparator.compare(iterator.next(), minimum)>= 0) {}
        }
        return minimum;
    }
    public static <T extends Comparable<? super T>> T min(Iterator <T> iterator){
        T minimum = null;
        while(iterator.hasNext()) {
            if(iterator.next().compareTo(minimum) >= 0) {}
        }
        return minimum;
    }
}
