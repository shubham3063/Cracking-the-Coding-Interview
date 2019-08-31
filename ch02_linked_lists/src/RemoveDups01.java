import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RemoveDups01 {
    private MySinglyLinkedList sll;
    public RemoveDups01() {
        sll = new MySinglyLinkedList();
        sll.addNodesRandomly(5, 10);
        //sll.addNodesFromArray(createArraysWithDups(20,10));
        sll.printList();
        this.run();
    }
    private void run(){
        System.out.println("HashMap:");
        removeDupsHashMap();
        sll.printList();

        System.out.println("Naive:");
        removeDupsNaive();
        sll.printList();
        System.out.println("----------------------");
    }

    private void removeDupsNaive() {
        Node iter1 = this.sll.getHead().getNext();

        while (iter1.getNext() != null) {
            Node iter2 = iter1.getNext();
            Node temp = iter1;
            while(iter2.getNext() != null) {
                if (iter2.getData() == iter1.getData()) {
                    temp.setNext(iter2.getNext());
                    iter2 = temp.getNext();
                } else {
                    temp = temp.getNext();
                    iter2 = iter2.getNext();
                }
            }

            iter1 = iter1.getNext();
        }

    }


    private void removeDupsHashMap() {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        Node iter = this.sll.getHead();
        while(iter.getNext() != null) {
            if (hashMap.containsKey(iter.getNext().getData())) {
                // remove the node
                iter.setNext(iter.getNext().getNext());
            } else {
                // put the node
                hashMap.put(iter.getNext().getData(), true);
                iter = iter.getNext();
            }
        }
    }

    private ArrayList<Integer> createArraysWithDups(int n, int bound) {
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(random.nextInt(10));
        }
        return arrayList;
    }
}
