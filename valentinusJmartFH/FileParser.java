package valentinusJmartFH;

public interface FileParser
{
    boolean read (String content);
    default Object newInstance (String content) {
        return null;
    };
    default Object write(){
        return null;
    };
}
