package fazaJmartFH;

public interface FileParser
{
  public boolean read (String content);
  
  public Object write();
  
  public static Object newInstance(String content)
  {
      return null;    
  }
}
