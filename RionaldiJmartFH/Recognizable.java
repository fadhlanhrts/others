package RionaldiJmartFH;


/**
 * Write a description of class Recognizable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Recognizable implements Comparable<Recognizable>
{
    public int id;
    
    protected Recognizable(){
        this.id = 1;
    }

    public static <T> int setClosingId(Class<T> clazz, int id){
        if(clazz.getSuperclass() == Recognizable.class){
            return 0;
        }
        return 0;
    }
    public static <T> int getClosingId(Class<T> clazz){
        if(clazz.getSuperclass() == Recognizable.class){
            return 0;
        }
     return 0;
    }

    @Override
    public int compareTo(Recognizable other) {
        return Integer.compare(this.id,other.id);
    }

    public boolean equals(Object object){
        if(object instanceof Recognizable){
            Recognizable r = (Recognizable) object;
            if(r.id == this.id){
                return true;
            }
        }
        return false;
    }
    
    public boolean equals(Recognizable recognizable){
        if(this.id == recognizable.id){
            return true;
        }
        return false;
        
    }


}


