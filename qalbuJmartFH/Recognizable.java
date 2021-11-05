package qalbuJmartFH;

public class Recognizable implements Comparable <Recognizable>{
    final public int id;
    
    protected Recognizable (int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Recognizable other) {
        return 0;
    }
    
    public boolean equals (Object other) {
        if (other instanceof Recognizable){
            return true;
        }else {
        return false;
    }
    }
    
    public boolean equals ( Recognizable other) {

        return true;
    }

    public static int getClosingId (Class<Recognizable> clazz){
        if (Class.class.isAssignableFrom(Recognizable.class) ){
            return 0;
        }else {
            return 1;
        }
    }

    public static int setClosingId (Class<Recognizable> clazz, int id){
        if (Class.class.isAssignableFrom(Recognizable.class) ){
            return 0;
        }else {
            return 1;
        }
    }


}
