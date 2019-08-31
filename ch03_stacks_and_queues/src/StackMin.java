import java.util.EmptyStackException;
import java.util.Random;

public class StackMin <T extends Comparable<T>> {

    StackMin () {
        top = null;
        currMin = null;
    }

    private static int num;

    public void run(int queryId, T item) {
        switch (queryId) {
            case 0:
                this.push(item);
                break;
            case 1:
                this.pop();
                break;
            case 2:
                this.peek();
                break;
            case 3:
                this.getCurrMin();
                break;
            case 4:
                this.isEmpty();
                break;
        }

    }


    private static class StackNode <T extends Comparable<T>>
        implements Comparable<T> {
        private T data;
        private StackNode<T> next;
        private T nextMin;

        public StackNode (T data) {
            this.data = data;
            this.nextMin = null;
        }

        @Override
        public int compareTo(T o) {
            return this.nextMin.compareTo(o);
        }
    }


    private StackNode<T> top;
    private T currMin;

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.data;

        currMin = top.nextMin;

        top = top.next;
        return item;
    }

    public void push (T item) {
        StackNode<T> t = new StackNode<>(item);
        t.next = top;
        top.next = t;

        t.nextMin = currMin;
        if (t.compareTo(currMin) < 0)
            currMin = t.data;
    }


    public T getCurrMin() {
        return this.currMin;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}


