
public class Intersection07 {
    private MySinglyLinkedList sll;
    private MySinglyLinkedList sll2;
    private int K;
    public Intersection07() {
        sll = new MySinglyLinkedList();
        sll.addNodesRandomly(10, 50);
        sll.printList();
        sll2 = new MySinglyLinkedList();
        sll2.addNodesRandomly(5,50);
        sll2.printList();

        Node it1 = sll2.getHead();
        while (it1.getNext() != null)
            it1 = it1.getNext();
        it1.setNext(sll.getHead().getNext().getNext().getNext());

        sll.printList();
        sll2.printList();
        this.run();
    }

    private void run() {
        int n1 = sll.getLength();
        int n2 = sll2.getLength();
        Node iter;
        if (n1 > n2)
            iter = sll.getHead();
        else iter = sll2.getHead();
        int diff = Math.abs(n1 - n2);

        while (diff > 0) {
            diff--;
            iter = iter.getNext();
        }
        System.out.println(diff + " " + iter + " " + iter.getData());
        Node node;
        if (n1 > n2)
            node = getIntersection(iter, sll2.getHead());
        else
            node = getIntersection(sll.getHead(),iter);
        System.out.println(node.getData());
    }

    private Node getIntersection(Node node1, Node node2) {
        System.out.println(node1 + " " + node2 + " " + node1.getData() + " " + node2.getData());
        if (node1 == node2) return node1;
        return getIntersection(node1.getNext(), node2.getNext());
    }
}
