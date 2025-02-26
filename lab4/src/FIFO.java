import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FIFO implements Queue {
    private ArrayList<Object> elements;
    private int maxSize;

    public FIFO() {
        elements = new ArrayList<>();
        maxSize = 0;
    }

    public void exception() {
        if (elements.isEmpty()) {
            throw new NoSuchElementException();
        }
    }
    @Override
    public void add(Object item) {
        elements.add(item);
        if (elements.size() > this.maxSize) {
            this.maxSize = elements.size();
        }
    }

    @Override
    public void removeFirst() {
        exception();
        elements.removeFirst();
    }

    @Override
    public Object first() {
        exception();
        return elements.getFirst();
    }

    @Override
    public int maxSize() {
        return maxSize;
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public String toString() {
        String text = "Queue: ";
        for (Object element: elements) {
            text = text + "(" + String.valueOf(element) + ") ";
        }
        return text;
    }

    @Override
    public boolean equals(Object f) {
        FIFO other = (FIFO) f;
        //Kommer casta ClassCastException ändå

        if (this.size() != other.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (this.elements.get(i) == null && other.elements.get(i) != null) {
                return false;
            }
            if (this.elements.get(i) != null && !this.elements.get(i).equals(other.elements.get(i))) {
                return false;
            }
        }
        return true;
    }
}
