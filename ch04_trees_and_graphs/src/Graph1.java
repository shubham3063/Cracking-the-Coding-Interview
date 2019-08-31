import java.util.ArrayList;

class Node1 {
    int data;
    Node1 next;
    Node1(int d) {
        this.data = d;
        this.next = null;
    }
}

public class Graph1 {
    public Graph1() {
        int n = 5;
        ArrayList<Node1> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new Node1(i));

        for (int i = 0; i < n; i++) {
            addEdge(graph, i, (i + 2) % n);
        }
        printGraph(graph);
    }
    public void addEdge(ArrayList<Node1> graph, int src, int dst) {
        Node1 node = new Node1(dst);
        node.next = graph.get(src).next;
        graph.get(src).next = node;
    }

    public void printGraph(ArrayList<Node1> graph) {
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + " -> ");
            Node1 iter = graph.get(i).next;
            while (iter != null) {
                System.out.print(iter.data + " ");
                iter = iter.next;
            }
            System.out.println();
        }
    }
}

