package matthewJmartFH;


/**
 * Write a description of class Recognizable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Recognizable
{
    // instance variables - replace the example below with your own
    private int x;
    public final int id;

    /**
     * Constructor for objects of class Recognizable
     */
    protected  Recognizable(int id)
    {
        // initialise instance variables
        this.id = id;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param 
     * @return    
     */
    public boolean equals(Object object )
    {   
        if(object instanceof Recognizable){
        Recognizable recognizable  = (Recognizable) object;
        if(this.id == recognizable.id)
        {
            return true;
        }
    }
        return false;
     }   
    
    
    public boolean equals(Recognizable x)
    {
        return true;
    }
}
