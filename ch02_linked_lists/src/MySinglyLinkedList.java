import java.util.ArrayList;
import java.util.Random;

public class MySinglyLinkedList {
    private Node head;

    public MySinglyLinkedList() {
        head = new Node(-1);
    }

    public Node getHead() {
        return head;
    }

    public void addNode(int d) {
        /**
         * Adds a node at the end of singly linked list
         */
        Node node = new Node(d);
        Node iter = this.head;
        while(iter.getNext() != null)
            iter = iter.getNext();
        iter.setNext(node);
    }

    public Node addNodesRandomly(int n, int bound) {
        Random random = new Random();
        for (int i = 0; i < n; i++)
            this.addNode(random.nextInt(bound));
        return this.head;
    }

    public Node addNodesFromArray(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            this.addNode(arrayList.get(i));
        }
        return this.head;
    }

    public void deleteNodeAtIdx(int idx) {
        /**
         * Deletes the node at index idx (zero-indexed)
         */
        int i = 0;
        Node iter = this.head;
        while(i < idx) {
            iter = iter.getNext();
            i++;
        }
        iter.setNext(iter.getNext().getNext());
    }

    public void reverseList() {
        Node curr, prev, next;
        prev = null;
        curr = this.getHead().getNext();
        next = curr.getNext();

        while (next != null) {
            curr.setNext(prev);
            prev = curr;
            curr = next;
            next = next.getNext();
        }

        curr.setNext(prev);
        this.getHead().setNext(curr);
    }

    public MySinglyLinkedList createCopy() {
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList();
        Node iter = this.getHead().getNext();
        while (iter != null) {
            mySinglyLinkedList.addNode(iter.getData());
            iter = iter.getNext();
        }
        return mySinglyLinkedList;
    }

    public int getLength() {
        Node iter = this.getHead();
        int n = 0;
        while (iter != null) {
            iter = iter.getNext();
            n++;
        }
        return n;
    }

    public Node getLastNode() {
        Node iter = this.getHead().getNext();
        while (iter.getNext() != null)
            iter = iter.getNext();
        return iter;
    }


    public void printList() {
        Node iter = this.head.getNext();
        while(iter.getNext() != null) {
            System.out.print(iter.getData() + " ");
            iter = iter.getNext();
        }
        System.out.println(iter.getData());
    }
}
