package qalbuJmartFH;

import java.util.Comparator;
import java.util.Iterator;

public class Algorithm {
    private Algorithm() {

    }

    public static <T> int count(T[] array, T value) {
        int counter = 0;
        for (T q : array) {
            counter++;
        }
        return counter;
    }

    public static <T> int count(Iterable<T> iterable, T value) {
        int counter = 0;
        for (T q : iterable) {
            counter++;
        }
        return counter;
    }

    public static <T> int count(Iterator<T> iterator, T value) {
        int counter = 0;
        if (iterator.hasNext()) {
            counter++;
        }
        return counter;
    }

    public static <T> int count (T [] array, Predicate <T> pred) {
        int counter = 0;
        if (pred.equals(false)) {
            return 0;
        }
        for (T q : array) {
            counter++;
        }
        return counter;
    }

    public static <T> int count (Iterable <T> iterable, Predicate <T> pred){
        int counter = 0;
        if (pred.equals(false)) {
            return 0;
        }
        for (T q : iterable){
            counter ++;
        }
        return counter;
    }

    public static <T> int count (Iterator <T> iterator, Predicate <T> pred){
        int counter = 0;
        if (pred.equals(false)) {
            return 0;
        }
        if (iterator.hasNext()) {
            counter++;
        }
        return counter;
    }

    public static <T> boolean exists (T [] array, T value){
    for (T q : array){
        if (q.equals (value)){
            return true;
        }
        }
        return false;
    }

    public static <T> boolean exists (Iterable <T> iterable, T value){
    for (T q : iterable){
        if (q.equals (value)){
            return true;
        }
        }
        return false;
    }

    public static <T> boolean exists (Iterator<T> iterator, T value ){
        while (iterator.hasNext()){
            if (iterator.next().equals (value)){
                return true;
            }
        }
        return false;
    }

    public static <T> boolean exists (T [] array, Predicate <T> pred){
        for (T q : array){
            if (q.equals (pred)){
                return true;
            }
        }
        return false;
    }

    public static <T> boolean exists (Iterable <T> iterable, Predicate <T> pred){
        for (T q : iterable){
            if (q.equals (pred)){
                return true;
            }
        }
        return false;
    }

    public static <T> boolean exists (Iterator <T> iterator, Predicate <T> pred){
        while (iterator.hasNext()){
            if (iterator.next().equals (pred)){
                return true;
            }
        }
        return false;
    }

    public static <T> T find (T [] array, T value){
        for (T q : array){
            if (q.equals (value)){
                return q;
            }
        }
        return null;
    }

    public static <T> T find (Iterable <T> iterable, T value){
        for (T q : iterable){
            if (q.equals (value)){
                return q;
            }
        }
        return null;
    }

    public static <T> T find (Iterator<T> iterator, T value ){
        while (iterator.hasNext()){
            if (iterator.next().equals (value)){
                return iterator.next();
            }
        }
        return null;
    }

    public static <T> T find (T [] array, Predicate <T> pred){
        for (T q : array){
            if (q.equals (pred)){
                return q;
            }
        }
        return null;

    }

    public static <T> T find (Iterable <T> iterable, Predicate <T> pred){
        for (T q : iterable){
            if (q.equals (pred)){
                return q;
            }
        }
        return null;
    }

    public static <T> T find (Iterator <T> iterator, Predicate <T> pred){
        while (iterator.hasNext()){
            if (iterator.next().equals (pred)){
                return iterator.next();
            }
        }
        return null;
    }

    public static <T extends  Comparable<?super T>> T max (T first, T second){
    if (first.compareTo(second) >= 0) {
        return first;
    }else {
        return second;
    }
    }

    public static <T extends  Comparable<?super T>> T max (T [] array){
    T maxi = null;
    for (T q : array){
        if (q.compareTo(maxi) >= 0){
            maxi = q;
        }else {
            maxi = maxi;
        }
    }
    return maxi;
    }

    public static <T extends  Comparable<?super T>> T max (Iterable <T> iterable){
        Iterator <T> iterator = iterable.iterator();
        T maxi = null;
        while (iterator.hasNext()){
            if (iterator.next().compareTo(maxi) >= 0){
                maxi = iterator.next();
            }
        }
        return maxi;
    }

    public static <T extends  Comparable<?super T>> T max (Iterator<T> iterator){
        return null;
    }

    public static <T extends  Comparable<?super T>> T max (T first, T second, Comparator <?super T> comparator){
        return null;
    }

    public static <T extends  Comparable<?super T>> T max (T[] [ ] array, Comparator <?super T> comparator){
        return null;
    }

    public static <T extends  Comparable<?super T>> T max (Iterable <T> iterable, Predicate <T> pred){
        return null;
    }

    public static <T extends  Comparable<?super T>> T max (Iterator <T> iterator, Predicate <T> pred){
        return null;
    }

    public static <T extends  Comparable<?super T>> T max (Iterable <T> Iterable, Comparator <?super T> comparator){
        return null;
    }

    public static <T extends  Comparable<?super T>> T max (Iterator<T> Iterator, Comparator <?super T> comparator){
        return null;
    }

    public static <T extends  Comparable<?super T>> T min (T [] array){
        return null;
    }

    public static <T extends  Comparable<?super T>> T min (Iterable <T> Iterable){
        return null;
    }

    public static <T extends  Comparable<?super T>> T min (Iterator<T> Iterator){
        return null;
    }

    public static <T extends  Comparable<?super T>> T min (T first, T second, Comparator <?super T> comparator){
        return null;
    }

    public static <T extends  Comparable<?super T>> T min (T[] [ ] array, Comparator <?super T> comparator){
        return null;
    }

    public static <T extends  Comparable<?super T>> T min (Iterable <T> iterable, Predicate <T> pred){
        return null;
    }

    public static <T extends  Comparable<?super T>> T min (Iterator <T> iterator, Predicate <T> pred){
        return null;
    }

    public static <T extends  Comparable<?super T>> T min (Iterable <T> Iterable, Comparator <?super T> comparator){
        return null;
    }

    public static <T extends  Comparable<?super T>> T min (Iterator<T> Iterator, Comparator<?super T> comparator){
        return null;
    }

}
