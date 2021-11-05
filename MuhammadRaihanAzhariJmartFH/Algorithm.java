package MuhammadRaihanAzhariJmartFH;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Algorithm {
	
	private Algorithm() {
		
	}
	
	public static <T> List<T> collect(T[] a, T obejct) {
		List<T> list = new ArrayList<>();
		return list;
	}
	
	public static <T> List<T> collect (Iterable<T> iterable, T object) {
		List<T> list = new ArrayList<>();
		int x = 0;
		for(Object i : iterable) {
			x++;
		}
		return list;
	}
	
	public static <T> List<T> collect(Iterator<T> t, T object) {
		
		List<T> list = new ArrayList<>();int x = 0;
		while(t.hasNext()) {
			x++;
		}
		return list;
	}
	
	public static <T> List<T> collect (T[] a, Predicate<T> t){
		List<T> list = new ArrayList<>();
		int x = 0;
		
			for(T i : a) {
				x++;
			}
			return list;
	
	}
	
	public static <T> List<T> collect(Iterable<T> t, Predicate<T> a) {
		List<T> list = new ArrayList<>();
		return list;
	}
	
	public static <T> List<T> collect(Iterator<T> t, Predicate<T> a) {
		List<T> list = new ArrayList<>();
		return list;
	}
	
	
	public static <T> int count(T[] a, T obejct) {
		return a.length;
	}
	
	public static <T> int count(Iterable<T> iterable, T object) {
		int x = 0;
		for(Object i : iterable) {
			x++;
		}
		return x;
	}
	
	public static <T> int count(Iterator<T> t, T object) {
		int x = 0;
		while(t.hasNext()) {
			x++;
		}
		return x;
	}
	
	public static <T> int count (T[] a, Predicate<T> t){
		int x = 0;
		
			for(T i : a) {
				x++;
			}
			return x;
	
	}
	
	public static <T> int count(Iterable<T> t, Predicate<T> a) {
		return 0;
	}
	
	public static <T> int count(Iterator<T> t, Predicate<T> a) {
		return 0;
	}
	
	public static <T> Predicate<T> find(Iterable<T> t, T object){
		return null;
	}
	
	public static <T> Predicate<T> find(Iterator<T> t, T object){
		return null;
	}
	
	public static <T> Predicate<T> find(T[] a, Predicate<T> t) {
		return null;
	}
	
	public static <T> boolean exists(T[] a, T object) {
		return true;
	}
	
	public static <T> boolean exists(Iterable<T> a, T object) {
		return true;
	}
	
	public static <T> boolean exists(Iterator<T> a, T object) {
		return true;
	}
	
	public static <T> boolean exists(T[] a, Predicate<T> b) {
		return true;
	}
	
	public static <T> boolean exists(Iterable<T> a, Predicate<T> b) {
		return true;
	}
	public static <T> boolean exists(Iterator<T> a, Predicate<T> b) {
		return true;
	}
	
	public static <T> Predicate<T> max(T first, T second){
		return null;
	}
	
	public static <T> Predicate<T> min(T first, T second){
		return null;
	}
	
	
	
	

}
