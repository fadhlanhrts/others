package qalbuJmartFH;

public interface FileParser {
    public boolean read (String content);
    default Object write (){
        return null;
    }
    public Object newInstance (String content);
}
