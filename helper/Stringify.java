package helper;

import java.util.function.Function;

public class Stringify
{
	public static <T> String arrToString(T[] obj)
	{
		if (obj == null) return "null";
		StringBuilder sb = new StringBuilder();
		if (obj.length == 0) return "";
		sb.append(obj[0]);
		for (int i = 1; i < obj.length; ++i)
			sb.append("," + obj[i]);
		return sb.toString();
	}
	
	public static <T> String arrToString(T[] obj, Function<T, String> translator)
	{
		if (obj == null) return "null";
		StringBuilder sb = new StringBuilder();
		if (obj.length == 0) return "";
		sb.append(translator.apply(obj[0]));
		for (int i = 1; i < obj.length; ++i)
			sb.append("," + translator.apply(obj[i]));
		return sb.toString();
	}
}