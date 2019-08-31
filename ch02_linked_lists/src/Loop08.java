public class Loop08 {
    private MySinglyLinkedList sll;
    private int K;
    public Loop08() {
        sll = new MySinglyLinkedList();
        sll.addNodesRandomly(10, 50);
        sll.printList();
        Node it1 = sll.getHead();
        while (it1.getNext() != null)
            it1 = it1.getNext();
        it1.setNext(sll.getHead().getNext().getNext().getNext().getNext());
//        sll.printList();
        this.run();
    }

    private void run() {
        Node head = sll.getHead();
        Node fast = head.getNext();
        Node slow = head.getNext();
        boolean flagIgnore = true; // ignore first time
        while (fast != slow || flagIgnore) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            flagIgnore = false;
        }
        Node start = head.getNext();
        while (start != slow) {
            slow = slow.getNext();
            start = start.getNext();
        }
        System.out.println(start.getData());
    }
}
