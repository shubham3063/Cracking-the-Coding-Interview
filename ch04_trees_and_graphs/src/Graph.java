import java.util.*;

class Node {
    int label;
    Node (int label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object obj) {
        Node objNode = (Node) obj;
        return objNode.label == this.label;
    }

    @Override
    public int hashCode() {
        return this.label;
    }
}

public class Graph {
    private Map<Node, List<Node>> adjNodes;
    

    public Graph() {
        this.adjNodes = new HashMap<Node, List<Node>>();
    }

    public void init(){
        int n = 5; // #nodes in graph
        for (int i = 0; i < n; i++) {
            this.addNode(i);
        }
        for (int i = 0; i < n; i++) {
            this.addEdge(i,(i + 2) % n);
            this.addEdge(i,(i + 3) % n);
        }
        this.removeEdge(0,2);
        this.removeEdge(1,4);
//        this.removeNode(3);
        System.out.println("Printing graph:");
        this.printGraph();
        System.out.println("---------------");
    }

    public Map<Node, List<Node>> getAdjNodes() {
        return adjNodes;
    }

    public  void addNode(int label) {
        adjNodes.putIfAbsent(new Node(label), new ArrayList<>());
    }

    public void removeNode(int label) {
        adjNodes.remove(new Node(label));
        for (List<Node> l : adjNodes.values())
            l.remove(new Node(label));
    }

    public void addEdge(int label1, int label2) {
        adjNodes.get(new Node(label1)).add(new Node(label2));
    }

    public void removeEdge(int label1, int label2) {
        adjNodes.get(new Node(label1)).remove(new Node(label2));
    }

    public List<Node> getAdjNodes(int label) {
        return adjNodes.get(new Node(label));
    }

    public LinkedList<Node> bfs(int src, int dst) {

        Map<Node, Boolean> visitedNodes = new HashMap<Node, Boolean>();
        Map<Node, Node> parent = new HashMap<Node, Node>();
        boolean flagFoundDst = false;

        LinkedList<Node> queue = new LinkedList<Node>();

        Node srcNode = new Node(src);
        queue.add(srcNode);
        visitedNodes.put(srcNode, true);

        while (!queue.isEmpty()) {
            Node node = queue.removeFirst();

            if (node.label == dst) {
                flagFoundDst = true;
                break;
            }

            List<Node> nodes = adjNodes.get(node);

            for (Node adjNode : nodes) {
                if (!visitedNodes.containsKey(adjNode)) {
                    queue.add(adjNode);
                    visitedNodes.put(adjNode, true);
                    parent.put(adjNode, node);
                }
            }
        }
        LinkedList<Node> path = new LinkedList<>();
        if (!flagFoundDst)
            return path;

        Node dstNode = new Node(dst);
        path.addFirst(dstNode);
        Node node = parent.get(dstNode);

        while (node.label != src) {
            path.addFirst(node);
            node = parent.get(node);
        }
        return path;
    }

    private void printGraph() {
        for (Node node : adjNodes.keySet()) {
            System.out.print(node.label + " -> ");
            List<Node> nodes = adjNodes.get(node);
            for (int i = 0; i < nodes.size(); i++)
                System.out.print(nodes.get(i).label + " ");
            System.out.println();
        }
    }
}
