package MuhammadRaihanAzhariJmartFH;


/**
 * Write a description of class Recognizable here.
 *
 * @author (Muhammad Raihan Azhari)
 * @version (25 Sept 2021)
 */
public class Recognizable implements Comparable<Recognizable>
{
   
    public int id;

    protected Recognizable()
    {
        id = 1;
    }
    
    public static  int getClosingId() {
    	return 0;
    }
    
    public static <T> int setClosingId(int id) {
    	return 0;
    }
    
   public boolean equals(Recognizable recognizable){
       return recognizable.id == id;
   }
    
   public boolean equals(Object object){
        if(object instanceof Recognizable){
            Recognizable obj = (Recognizable)object;
            if(obj.id == id){
               return true; 
            }
       }
       return false;
   }
   
   public int compareTo(Recognizable recognizable) {
	   return (this.id / recognizable.id);
   }
   
   
}
