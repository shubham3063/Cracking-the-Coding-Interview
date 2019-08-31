public class Partition04 {
    private MySinglyLinkedList sll;
    private int X, Y;
    public Partition04() {
        sll = new MySinglyLinkedList();
        sll.addNodesRandomly(10, 10);
        sll.printList();
        this.X = 4;
        this.Y = 6;
        this.run();
    }

    private void run() {
        System.out.println("Naive:");
        Partition04Naive();
//        System.out.println("Three way partition");
//        Partition04ThreeWay(this.X, this.Y);
        sll.printList();
        System.out.println("----------------------");
    }

    private void Partition04Naive() {
        // move the current pointer to the node with data >= X
        Node prev = this.sll.getHead();
        Node curr = prev.getNext();
        while(curr != null && curr.getData() < this.X) {
            prev = curr;
            curr = curr.getNext();
        }

        while(curr != null) {
            if(curr.getData() < this.X) {
                // for the node with data >= X, remove and insert at start
                prev.setNext(curr.getNext());
                curr.setNext(this.sll.getHead().getNext());
                this.sll.getHead().setNext(curr);
                curr = prev.getNext();
            } else {
                // update curr to the next node and leave prev at the same node
                prev = curr;
                curr = curr.getNext();
            }
        }
    }

    private void Partition04ThreeWay(int M, int N) {
        Node prev = this.sll.getHead();
        Node curr = prev.getNext();
        Node last = this.sll.getHead();
        Node head = this.sll.getHead();
        while (last.getNext() != null)
            last = last.getNext();

        while(curr != null && curr.getData() < M) {
            prev = curr;
            curr = curr.getNext();
        }

        while(curr != null) {
            if (curr.getData() < M) {
                prev.setNext(curr.getNext());
                curr.setNext(head.getNext());
                head.setNext(curr);
                curr = prev.getNext();
            }
            else if (curr.getData() >= N) {
                prev.setNext(curr.getNext());
                last.setNext(curr);
                curr.setNext(null);
                curr = prev.getNext();
            }
            else {
                prev = curr;
                curr = curr.getNext();
            }
        }
    }

}
