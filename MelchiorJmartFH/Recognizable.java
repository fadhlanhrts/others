package MelchiorJmartFH;

public abstract class Recognizable implements Comparable<Recognizable> {
	public int id;

	protected Recognizable() {
		this.id = 1;
	}

	public static int setClosingId(Class<Recognizable> clazz, int id) {
		if (Class.class.isAssignableFrom(Recognizable.class)) {
			return 0;
		} else {
			return 1;
		}
	}

	public static int getClosingId(Class<Recognizable> clazz) {
		if (Class.class.isAssignableFrom(Recognizable.class)) {
			return 0;
		} else {
			return 1;
		}
	}

	public boolean equals(Object newObject) {
		return (newObject instanceof Recognizable) && ((Recognizable) newObject).id == id;
	}

	public boolean equals(Recognizable recognize) {
		if (this.id == recognize.id) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(Recognizable other) {
		if (id == other.id) {
			return 1;
		} else {
			return 0;
		}
	}
}
