import java.util.EmptyStackException;

public class QueueViaStack<T> {
    // two top: for two stacks
    //
    // methods:
    // add to last: stack push
    // remove from front: empty stack in second stack, remove, re-fill first stack
    // peek front: empty 1st stack in 2nd stack, peek, re-fill 1st stack
    // isEmpty queue: curr stack is null

//    public static class StackNode <T> {
//        T data;
//        StackNode<T> next;
//        StackNode(T data){
//            this.data = data;
//            this.next = null;
//        }
//    }

    MyStack<T> stack1, stack2;

    QueueViaStack() {
        this.stack1 = new MyStack<T>();
        this.stack2 = new MyStack<T>();
    }

    public void add(T item) {
        stack1.push(item);
    }



    public T remove() {
        if (stack1.isEmpty())
            throw new EmptyStackException();
        T data = null;
        while (stack1.isEmpty() == false) {
            data = stack1.pop();
            stack2.push(data);
        }
        stack2.pop();
        while (stack2.isEmpty() == false) {
            stack1.push(stack2.pop());
        }
        return data;
    }

    public T peek() {
        if (stack1.isEmpty())
            throw new EmptyStackException();
        T data = null;
        while (stack1.isEmpty() == false) {
            data = stack1.pop();
            stack2.push(data);
        }
        while (stack2.isEmpty() == false) {
            stack1.push(stack2.pop());
        }
        return data;
    }

    public boolean isEmpty() {
        if (stack1.isEmpty())
            return true;
        else return false;
    }
}
