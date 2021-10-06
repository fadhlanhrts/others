package jmart.goldenSample.dbjson;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Collections;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class JSONTable<T>
{
    private static final Gson gson = new Gson();

    public final String filepath;
    public final ArrayList<T> list;
    
    @SuppressWarnings("unchecked")
    public JSONTable(Class<T> clazz, String filepath) throws ClassNotFoundException, FileAlreadyExistsException
    {
        this.filepath = filepath;
        this.list = new ArrayList<T>();
        boolean fileNotExists = true;
        try
        {
            Class<T[]> arrayType = (Class<T[]>) Class.forName("[L" + clazz.getName() + ";");
            T[] loaded = load(arrayType, filepath);
            if (loaded != null)
                Collections.addAll(list, loaded);
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
        writer.write(gson.toJson(list));
        writer.close();
    }

    private static <T> T load(Class<T> clazz, String filepath) throws FileNotFoundException
    {
        final JsonReader reader = new JsonReader(new FileReader(filepath));
        return gson.fromJson(reader, clazz);
    }
}
