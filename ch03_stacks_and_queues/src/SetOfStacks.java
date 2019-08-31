import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Random;

public class SetOfStacks <T> {
    private static class StackNode <T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private static class SetStackNode <T> {
       SetStackNode<T> setStackNext;
       StackNode<T> stackNext;
       int nItems;

       SetStackNode () {
           this.stackNext = null;
           this.setStackNext = null;
           this.nItems = 0;
       }
    }


    private int thresh;
    private SetStackNode<T> setTop;
    private boolean flagNewSetStack;

    SetOfStacks (int thresh) {
        this.thresh = thresh;
        this.setTop = null;
    }

    public void push(T item) {

        // setTop is null
        // #items in curr set stack node = thresh
        // #items in curr set stack node != thresh

        if (setTop == null || setTop.nItems == this.thresh) {
            System.out.println("Current stack null or full");
            SetStackNode<T> setStackNode = new SetStackNode<>();
            setStackNode.setStackNext = setTop;
            setTop = setStackNode;
        }

        StackNode<T> stackNode = new StackNode<>(item);
        stackNode.next = setTop.stackNext;
        setTop.stackNext = stackNode;
        setTop.nItems++;
    }

    public T pop() {
        // no element
        // non-last element in curr set stack
        // last element in full set stack
        // last element in curr set stack
        if (setTop == null)
            throw new EmptyStackException();
        StackNode<T> node = setTop.stackNext;
        T data = node.data;
        setTop.stackNext = node.next;
        node.next = null;
        setTop.nItems--;
        if (setTop.stackNext == null) {
            System.out.println("No item on current stack");
            SetStackNode<T> setNode = setTop;
            setTop = setNode.setStackNext;
            setNode.stackNext = null;
        }

        return data;
    }
}
