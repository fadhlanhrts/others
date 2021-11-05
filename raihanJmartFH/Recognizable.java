package RaihanJmartFH;

public class Recognizable implements Comparable <Recognizable> {
    public final int id;

    protected Recognizable(int id) {
        this.id = id;
    }

    public boolean equals(Object object) {
        return (object instanceof Recognizable && this.id == ((Recognizable) object).id);
    }

    @Override
    public int compareTo(Recognizable other) {
        if (id == other.id) {
            return 1;
        } else {
            return 0;
        }
    }

    public int setClosingId(Class<Recognizable> clazz, int id) {
        if (Class.class.isAssignableFrom(Recognizable.class)) {
            return 0;
        } else {
            return 1;
        }
    }

    public int getClosingId(Class<Recognizable> clazz) {
        if (Class.class.isAssignableFrom(Recognizable.class)) {
            return 0;
        } else return 1;
    }
}
