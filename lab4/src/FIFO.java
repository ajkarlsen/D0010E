import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FIFO implements Queue {
    private ArrayList<Object> elements;
    private int maxSize;

    public FIFO() {
        elements = new ArrayList<>();
        maxSize = 0;
    }

    @Override
    public void add(Object item) {
    }

    @Override
    public void removeFirst() {
    }

    @Override
    public Object first() {
        return elements.getFirst();
    }

    @Override
    public int maxSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public boolean equals(Object f) {
        return false;
    }
}
