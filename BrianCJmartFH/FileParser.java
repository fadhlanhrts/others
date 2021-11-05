package BrianCJmartFH;
abstract interface FileParser {
    boolean read(String content) {

    }

    default Object write() {
        return null;
    }

    Object newInstance(String content) {
        return null;
    }
}
