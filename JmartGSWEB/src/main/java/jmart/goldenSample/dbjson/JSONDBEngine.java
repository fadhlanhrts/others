package jmart.goldenSample.dbjson;

import jmart.goldenSample.Algorithm;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

@SuppressWarnings("unchecked")
public class JSONDBEngine
{
    public static void fetch(Class<?> sourceClass)
    {
    	try
		{
    		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(true);
    		scanner.addIncludeFilter(new AnnotationTypeFilter(JSONDBContainer.class));
    		for (BeanDefinition bd : scanner.findCandidateComponents(sourceClass.getPackageName()))
    		{
        		Class<?> classContainer = Class.forName(bd.getBeanClassName());
        		Set<Class<?>> loadedDatabases = new HashSet<>();
        		for (Field f : classContainer.getFields())
        		{
        			JSONDBContainer ann = f.getAnnotation(JSONDBContainer.class);
        			if (ann == null) continue;
        			// annotation content
        			Class<?> value  = ann.value();
            		String filepath = ann.filepath();
            		// create directory tree if requested
            		File parentFile = new File(filepath).getParentFile();
            		if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs())
            			throw new Throwable("Failed to create " + parentFile);
            		// load json database table
            		final JSONTable<?> table = new JSONTable<>(value, filepath);
            		// if Serializable, find maximum value
            		// so the next object created can follow up the counter
                    if (Serializable.class.isAssignableFrom(value))
                    {
                        final Serializable serial = Algorithm.max((JSONTable<? extends Serializable>) table);
                        if (serial != null)
                            Serializable.setClosingId((Class<? extends Serializable>) value, serial.id);
                    }
                    f.setAccessible(true);
                    f.set(null, table);
        		}
    		}
		}
    	catch (Throwable t)
		{
			t.printStackTrace();
			System.err.println(t);
			System.exit(1);
		}
    }
}
