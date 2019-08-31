public class SortStack<T> {
    // two stacks
    private MyStack<Integer> stack1, stack2;
    SortStack(){
        stack1 = new MyStack<Integer>();
        stack2 = new MyStack<Integer>();
    }

    public void push(int item) {
        stack1.push(item);
    }

    public void sort() {
        // maintain a 2nd stack with increasing data
        // if a data with less value comes push back all data from 2nd stack to 1st stack until the value in the 2nd
        // stack is less than current data
        // push all the items back to 2nd stack

        // stack2 is null
        // stack2 has data

        while (!stack1.isEmpty()) {
            int data = stack1.pop();
            int count = 0;
            while (!stack2.isEmpty() && stack2.peek() > data) {
                stack1.push(stack2.pop());
                count++;
            }

            stack2.push(data);

            while (count > 0) {
                stack2.push(stack1.pop());
                count--;
            }
        }

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        printStack();
    }

    private void printStack() {
        while (stack1.isEmpty() == false) {
            System.out.print(stack1.pop() + " ");
        }
    }
}
