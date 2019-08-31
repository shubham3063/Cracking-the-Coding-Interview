import java.util.ArrayList;

class Node2 {
    int label;
    Node2(int label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object obj) {
        Node2 objNode = (Node2) obj;
        return objNode.label == this.label;
    }
}

public class Graph2 {
    private ArrayList<ArrayList<Node2>> graph;
    Graph2() {
        graph = new ArrayList<>();
        int n = 5; // #nodes in graph
        for (int i = 0; i < n; i++) {
            addNode(i);
        }
        for (int i = 0; i < n; i++) {
            addEdge(i,(i + 1) % n);
            addEdge(i,(i + 2) % n);
        }
        this.printGraph();
    }

    private void addNode(int src) {
        graph.add(src, new ArrayList<>());

    }

    // remove node is not possible using arraylist, use hashmap instead.
    // because it is not possible to index list of adj nodes when src is removed
    // all src nodes shift one above.
    private void removeNode(int src) {
        graph.remove(src);
    }

    private void addEdge(int src, int dst) {
        graph.get(src).add(new Node2(dst)); // directional, reverse edge not added
    }

    // this is possible
    private void removeEdge(int src, int dst) {
        ArrayList<Node2> adjSrcNodes = graph.get(src);
        adjSrcNodes.remove(adjSrcNodes.indexOf(dst)); // directional, reverse edge not removed
    }

    private ArrayList<Node2> getAdjNodes(int src) {
        return graph.get(src);
    }

    private void printGraph() {
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(graph.get(i).get(j).label + " ");
            }
            System.out.println();
        }
    }



}
