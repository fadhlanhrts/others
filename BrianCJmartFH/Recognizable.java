package BrianCJmartFH;

public abstract class Recognizable {
    final int id=0;
    Recognizable(int id) {
        
    }

    public boolean equals(Object object) {
        Recognizable obj = (Recognizable) new Object();
        return (
            object instanceof Recognizable 
            && 
            obj.id == this.id
        );
    }

    boolean equals(Recognizable recognizable) {
        return recognizable.id == this.id;
    }
}
