public class Palindrome06 {
    private MySinglyLinkedList sll;
    private boolean retBool;
    public Palindrome06() {
        this.retBool = true;
        sll = new MySinglyLinkedList();
        sll.addNodesRandomly(10,10);
        sll.printList();

        MySinglyLinkedList sll2 = sll.createCopy();
        sll2.reverseList();
        sll2.printList();
//        this.run();
        Node last = sll.getLastNode();
        last.setNext(sll2.getHead().getNext());
        sll.printList();
        this.run();
    }

    private void run(){
        fun(this.sll.getHead().getNext());
        System.out.println("Palindrome Recursive: " + this.retBool);
    }

    private Node fun(Node node) {
        //System.out.println(node.getData());
        if (node == null)
            return this.sll.getHead().getNext();
        //System.out.println(node.getData());
        Node retNode = fun(node.getNext());
        if (this.retBool == true && retNode.getData() == node.getData()) {
            this.retBool = true;
        } else {
            this.retBool = false;
        }
        return retNode.getNext();
    }
}
