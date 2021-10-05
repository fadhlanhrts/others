package jmart.goldenSample.controller;

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
    public final ArrayList<T> table;

    private JSONTable(String filepath)
    {
        this.filepath = filepath;
        this.table = new ArrayList<T>();
    }
    
    @SuppressWarnings("unchecked")
    public static <T> JSONTable<T> createFromFile(Class<T> clazz, String filepath) throws ClassNotFoundException, FileAlreadyExistsException
    {
        JSONTable<T> instance = new JSONTable<T>(filepath);
        boolean fileNotExists = true;
        try
        {
            Class<T[]> arrayType = (Class<T[]>) Class.forName("[L" + clazz.getName() + ";");
            T[] loaded = JSONTable.load(arrayType, filepath);
            if (loaded != null)
                Collections.addAll(instance.table, loaded);
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
        return instance;
    }

    public void write() throws IOException
    {
        final FileWriter writer = new FileWriter(filepath);
        writer.write(gson.toJson(table));
        writer.close();
    }

    private static <T> T load(Class<T> clazz, String filepath) throws FileNotFoundException
    {
        final JsonReader reader = new JsonReader(new FileReader(filepath));
        return gson.fromJson(reader, clazz);
    }
}
