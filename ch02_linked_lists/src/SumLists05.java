public class SumLists05 {
    MySinglyLinkedList l1;
    MySinglyLinkedList l2;
    SumLists05() {
        l1 = new MySinglyLinkedList();
        l2 = new MySinglyLinkedList();

        l1.addNodesRandomly(5,10);
        l2.addNodesRandomly(8,10);

        l1.printList();
        l2.printList();

        this.run();
    }

    private void run() {

    }

    private void sumListsRecursive(Node i1, Node i2) {
        if (i1 == null || i2 == null) return;
        sumListsRecursive(i1.getNext(), i2.getNext());

    }

    private void sumListsIterative() {
        Node i1 = l1.getHead().getNext();
        Node i2 = l2.getHead().getNext();

        int carry = 0, sum = 0;

        MySinglyLinkedList l3 = new MySinglyLinkedList();

        while (i1 != null && i2 != null) {
            sum = i1.getData() + i2.getData() + carry;
            carry = sum / 10;
            l3.addNode(sum % 10);
            sum = 0;

            i1 = i1.getNext();
            i2 = i2.getNext();
        }

        if (i1 == null && i2 == null) {
            l3.addNode(carry);
        } else {
            Node i3;
            if (i1 == null)
                i3 = i2;
            else i3 = i1;

            while (i3 != null) {
                sum = i3.getData() + carry;
                carry = sum / 10;
                l3.addNode(sum % 10);
                i3 = i3.getNext();
                sum = 0;
            }
        }
        l3.printList();
    }
}
