import java.util.NoSuchElementException;

public class MyQueue<T> {
    public static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T item) {
        QueueNode<T> node = new QueueNode<T>(item);
        if (last != null)
            last.next = node;
        last = node;
        if (first == null)
            first = last;
    }

    public T remove() {
        if (first == null) throw new NoSuchElementException();
        T item = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return item;
    }

    public T peek() {
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
