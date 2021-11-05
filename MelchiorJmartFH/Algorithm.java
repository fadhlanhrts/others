package MelchiorJmartFH;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Algorithm {
	private Algorithm() {

	}

	public static <T> List<T> collect(T[] array, T value) {
		final Iterator<T> it = Arrays.stream(array).iterator();
		return collect(it, value);
	}

	public static <T> List<T> collect(Iterable<T> iterable, T value) {
		final Iterable<T> e = (Iterable<T>) iterable.iterator();
		return collect(e, value);
	}

	public static <T> List<T> collect(Iterator<T> iterator, T value) {
		final Predicate<T> predicate = value::equals;
		return collect(iterator, value);
	}

	public static <T> List<T> collect(T[] array, Predicate<T> pred) {
		final Iterator<T> itArray = Arrays.stream(array).iterator();
		return collect(itArray, pred);
	}

	public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred) {
		int counter = 0;
		while (iterator.hasNext()) {
			counter++;
		}
		final Predicate<T> predicate = pred::equals;
		return collect(iterator, pred);
	}

	public static <T> int count(T[] array, T value) {
		int counter = 0;
		for (T i : array) {
			counter++;
		}
		return counter;
	}

	public static <T> int count(Iterable<T> iterable, T value) {
		int counter = 0;
		for (T i : iterable) {
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

	public static <T> int count(T[] array, Predicate<T> pred) {
		int counter = 0;
		if (pred.equals(false)) {
			return 0;
		} else {
			for (T i : array) {
				counter++;
			}
		}
		return counter;
	}

	public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
		int counter = 0;
		if (pred.equals(false)) {
			return 0;
		} else {
			for (T i : iterable) {
				counter++;
			}
		}
		return counter;
	}

	public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
		int counter = 0;
		if (pred.equals(false)) {
			return 0;
		} else {
			while (iterator.hasNext()) {
				counter++;
			}
		}
		return counter;
	}

	public static <T> boolean exists(T[] array, T value) {
		for (T i : array) {
			if (i.equals(value)) {
				return true;
			}
		}
		return false;
	}

	public static <T> boolean exists(Iterable<T> iterable, T value) {
		for (T i : iterable) {
			if (i.equals(value)) {
				return true;
			}
		}
		return false;
	}

	public static <T> boolean exists(Iterator<T> iterator, T value) {
		while (iterator.hasNext()) {
			if (iterator.next().equals(value)) {
				return true;
			}
		}
		return false;
	}

	public static <T> boolean exists(T[] array, Predicate<T> pred) {
		for (T i : array) {
			if (i.equals(pred)) {
				return true;
			}
		}
		return false;
	}

	public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
		for (T i : iterable) {
			if (i.equals(pred)) {
				return true;
			}
		}
		return false;
	}

	public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
		while (iterator.hasNext()) {
			if (iterator.next().equals(pred)) {
				return true;
			}
		}
		return false;
	}

	public static <T> T find(T[] array, T value) {
		for (T i : array) {
			if (i.equals(value)) {
				return i;
			}
		}
		return null;
	}

	public static <T> T find(Iterable<T> iterable, T value) {
		for (T i : iterable) {
			if (i.equals(value)) {
				return i;
			}
		}
		return null;
	}

	public static <T> T find(Iterator<T> iterator, T value) {
		while (iterator.hasNext()) {
			if (iterator.next().equals(value)) {
				return iterator.next();
			}
		}
		return null;
	}

	public static <T> T find(T[] array, Predicate<T> pred) {
		for (T i : array) {
			if (i.equals(pred)) {
				return i;
			}
		}
		return null;
	}

	public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
		for (T i : iterable) {
			if (i.equals(pred)) {
				return i;
			}
		}
		return null;
	}

	public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
		while (iterator.hasNext()) {
			if (iterator.next().equals(pred)) {
				return iterator.next();
			}
		}
		return null;
	}

	public static <T> T max(T first, T second) {
		if (first.hashCode() > second.hashCode()) {
			return first;
		} else {
			return second;
		}
	}

	public static <T> T max(T[] array) {
		int max = 0;
		T maxVal = null;
		for (T i : array) {
			if (i.hashCode() > max) {
				max = i.hashCode();
				maxVal = i;
			}
		}
		return maxVal;
	}

	public static <T> T max(Iterable<T> iterable, T value) {
		if (iterable.hashCode() > value.hashCode()) {
			return (T) iterable;
		} else {
			return value;
		}
	}

	public static <T> T max(Iterator<T> iterator, T value) {
		if (iterator.next().hashCode() > value.hashCode()) {
			return iterator.next();
		} else {
			return value;
		}
	}

	public static <T> T max(T first, T second, Comparator<? super T> comparator) {
		int result = ((Comparable<T>) first).compareTo(second);
		return result == -1 ? second : first;
	}

	public static <T> T max(T[] array, Comparator<? super T> comparator) {
		int max = 0;
		T maxVal = null;
		for (T i : array) {
			if (i.hashCode() > max) {
				max = i.hashCode();
				maxVal = i;
			}
		}
		int result = ((Comparable<T>) comparator).compareTo((T) array);
		return max(array, comparator);
	}

	public static <T> T max(Iterable<T> iterable, Comparator<? super T> comparator) {
		T maxVal = null;
		for (T i : iterable) {
			if (((Comparable<T>) maxVal).compareTo(i) < 0) {
				maxVal = i;
			}
		}
		return maxVal;
	}

	public static <T> T max(Iterator<T> iterator, T value, Comparator<? super T> comparator) {
		int result = ((Comparable<T>) iterator).compareTo(value);
		if (iterator.next().hashCode() > value.hashCode()) {
			return iterator.next();
		} else {
			return value;
		}
	}

	public static <T> T min(T first, T second) {
		if (first.hashCode() > second.hashCode()) {
			return second;
		} else {
			return first;
		}
	}

	public static <T> T min(T[] array) {
		int min = array[0].hashCode();
		T minVal = null;
		for (T i : array) {
			if (i.hashCode() > min) {
				min = i.hashCode();
				minVal = i;
			}
		}
		return minVal;
	}

	public static <T> T min(Iterable<T> iterable) {
		int min = iterable.hashCode();
		T minVal = null;
		for (T i : iterable) {
			if (i.hashCode() > min) {
				min = i.hashCode();
				minVal = i;
			}
		}
		return minVal;
	}

	public static <T> T min(Iterator<T> iterator) {
		int min = iterator.next().hashCode();
		T minVal = null;
		while (iterator.hasNext()) {
			if (iterator.next().hashCode() > min) {
				min = iterator.next().hashCode();
				minVal = iterator.next();
			}
		}
		return minVal;
	}

	public static <T> T min(T first, T second, Comparator<? super T> comparator) {
		int result = ((Comparable<T>) first).compareTo(second);
		return result == -1 ? second : first;
	}

	public static <T> T min(T[] array, Comparator<? super T> comparator) {
		int min = 0;
		T minVal = null;
		for (T i : array) {
			if (i.hashCode() > min) {
				min = i.hashCode();
				minVal = i;
			}
		}
		int result = ((Comparable<T>) comparator).compareTo((T) array);
		return min(array, comparator);
	}

	public static <T> T min(Iterable<T> iterable, Comparator<? super T> comparator) {
		T minVal = null;
		for (T i : iterable) {
			if (((Comparable<T>) minVal).compareTo(i) > 0) {
				minVal = i;
			}
		}
		return minVal;
	}

	public static <T> T min(Iterator<T> iterator, T value, Comparator<? super T> comparator) {
		int result = ((Comparable<T>) iterator).compareTo(value);
		if (iterator.next().hashCode() < value.hashCode()) {
			return iterator.next();
		} else {
			return value;
		}
	}
}
