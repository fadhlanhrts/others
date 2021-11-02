package jmart.goldenSample.dbjson;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.Collections;
import java.util.Vector;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class JSONTable<T> extends Vector<T>
{
    private static final Gson gson = new Gson();
    public final String filepath;
    
    @SuppressWarnings("unchecked")
    public JSONTable(Class<T> clazz, String filepath) throws ClassNotFoundException, FileAlreadyExistsException
    {
        this.filepath = filepath;
        boolean fileNotExists = true;
        try
        {
            Class<T[]> arrayType = (Class<T[]>) Class.forName("[L" + clazz.getName() + ";");
            T[] loaded = read(arrayType, filepath);
            if (loaded != null)
                Collections.addAll(this, loaded);
        }
        catch (FileNotFoundException e)
        {
            try { fileNotExists = new File(filepath).createNewFile(); }
            catch (IOException t)
            {
                t.printStackTrace();
                System.exit(-1);
            }
        }
        if (!fileNotExists)
            throw new FileAlreadyExistsException(filepath);
    }

    public void write() throws IOException
    {
        final FileWriter writer = new FileWriter(filepath);
        writer.write(gson.toJson(this));
        writer.close();
    }

    public static <T> T read(Class<T> clazz, String filepath) throws FileNotFoundException
    {
        final JsonReader reader = new JsonReader(new FileReader(filepath));
        return gson.fromJson(reader, clazz);
    }
}
