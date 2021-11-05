package DivaJmartFH;


/**
 * Write a description of interface FileParser here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface FileParser
{public boolean read(String content);
    
    default Object write(Object content){
    return null;}
    static Object newInstance(String content){
    return null;}
    
    
}
