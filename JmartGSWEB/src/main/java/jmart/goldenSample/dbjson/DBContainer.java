package jmart.goldenSample.dbjson;

import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.HashMap;

import jmart.goldenSample.Algorithm;

@SuppressWarnings("unchecked")
public class DBContainer
{
	private static final HashMap<Class<?>, JSONTable<?>> MAP_TABLE = new HashMap<>();
	
	public static <T> JSONTable<T> fetch(Class<T> clazz, String filepath) throws FileAlreadyExistsException, ClassNotFoundException
	{
		final JSONTable<T> table = new JSONTable<T>(clazz, filepath);
		if (Serializable.class.isAssignableFrom(clazz))
		{
			final Serializable serial = Algorithm.max((JSONTable<? extends Serializable>) table);
			if (serial != null)
				Serializable.setClosingId((Class<? extends Serializable>) clazz, serial.id);
		}
        MAP_TABLE.put(clazz, table);
        return table;
	}
	
	public static <T> JSONTable<T> getTable(Class<T> clazz)
	{
		return (JSONTable<T>) MAP_TABLE.get(clazz);
	}
}