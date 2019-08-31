import java.util.Random;

public class ThreeInOne {
    private int[] stack;
    private int[] start, end, top;
    private int nArray, mStacks, itemBound, nSimSteps;

    public ThreeInOne() {
        this.nArray  = 20;
        this.mStacks = 3;
        this.itemBound = 100;
        this.nSimSteps = this.nArray * 10;
        this.run();
    }

    private void run() {

        stack = new int[nArray];
        start = new int[mStacks];
        end   = new int[mStacks];
        top   = new int[mStacks];

        for (int i = 0; i < mStacks; i++) {
            start[i] = i * nArray/3;
            top[i] = start[i];
            if (i > 0)
                end[i-1] = start[i] - 1;
        }

        end[mStacks-1] = nArray - 1;

        // simulate stack pushes, pops, peeks and empty queries
        Random random = new Random();
        for (int i = 0; i < this.nSimSteps; i++) {
            int stackId = random.nextInt(this.mStacks);
            int item    = random.nextInt(100);
            int query   = random.nextInt(4);
            switch (query) {
                case 0:
                    System.out.println("[Push] stack: [" + stackId + "] item: (" + item + ")");
                    this.push(stackId, item);
                    break;
                case 1:
                    System.out.println("[Pop] stack: [" + stackId + "]");
                    this.pop(stackId);
                    break;
                case 2:
                    System.out.println("[Peek] stack: [" + stackId + "]");
                    this.peek(stackId);
                    break;
                case 3:
                    System.out.println("[Empty] stack: [" + stackId + "]");
                    this.isEmpty(stackId);
                    break;
            }
            if (i % 10 == 0)
                this.printStack();
        }
        this.printStack();
    }

    private void printStack() {
        System.out.print("    [Print] ");
        for (int i = 0; i < this.stack.length; i++) {
            System.out.print(this.stack[i] + " ");
        }
        System.out.println();
    }

    private void push(int stackId, int item) {

        if (top[stackId] > end[stackId]) {
            System.out.println("     [Info] Stack [" + stackId + "]: limit exceeded");
        } else {
            stack[top[stackId]] = item;
            top[stackId]++;
        }
    }

    private int pop(int stackId) {
        if (top[stackId] == start[stackId]) {
            System.out.println("     [Info] Stack [" + stackId + "]: no elements in stack");
        } else {
            top[stackId]--;
        }
        return stack[top[stackId]];
    }

    private int peek(int stackId) {
        if (top[stackId] > start[stackId]) {
            return stack[top[stackId]-1];
        } else {
            System.out.println("     [Info] Stack [" + stackId + "]: no elements in stack");
            return Integer.MIN_VALUE;
        }
    }

    private boolean isEmpty(int stackId) {
        boolean isempty = top[stackId] == start[stackId];
        if (isempty)
            System.out.println("     [Info] Stack [" + stackId + "]: is empty");
        else
            System.out.println("     [Info] Stack [" + stackId + "]: is not empty");
        return isempty;
    }
}
