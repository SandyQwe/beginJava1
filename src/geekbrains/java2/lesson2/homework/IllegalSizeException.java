package geekbrains.java2.lesson2.homework;

/**
 * Created by sadmin on 14.09.2016.
 */
public class IllegalSizeException extends RuntimeException {
    private String description;

    public IllegalSizeException (String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "IllegalSizeException:" + description;
    }
}
