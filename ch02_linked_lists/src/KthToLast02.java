public class KthToLast02 {
    private MySinglyLinkedList sll;
    private int K;
    public KthToLast02() {
        sll = new MySinglyLinkedList();
        sll.addNodesRandomly(5, 50);
        sll.printList();
        this.K = 3;
        this.run();
    }

    private void run() {
        System.out.println("K = " + this.K);
        System.out.println("Runner technique: " + kthToLastRunner(this.K));
        System.out.println("Naive:" + kthToLastNaive(this.K));
        kthToLastRecursive(this.sll.getHead());
        System.out.println("----------------------");
    }

    private int kthToLastRunner(int k) {
        Node iter = this.sll.getHead();
        Node iterk = this.sll.getHead();
        while(iter.getNext() != null) {
            if (k <= 0) {
                iterk = iterk.getNext();
            }
            k--;
            iter = iter.getNext();
        }
        return iterk.getData();
    }

    private int kthToLastNaive(int k) {
        Node iter = this.sll.getHead();
        int len = 0;
        while (iter.getNext() != null) {
            len++;
            iter = iter.getNext();
        }
        int idx = len - k;
        iter = this.sll.getHead();
        while(idx > 0) {
            iter = iter.getNext();
            idx--;
        }
        return iter.getData();
    }

    private int kthToLastRecursive(Node node) {
        if (node.getNext() == null)
            return this.K - 1;
        int k = kthToLastRecursive(node.getNext());
        if (k == 0)
            System.out.println("Recursive: " + node.getData());
        return k - 1;
    }
}
