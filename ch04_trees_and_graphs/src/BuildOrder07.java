import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BuildOrder07 {
    private Graph graph;

    BuildOrder07() {
        graph = new Graph();
        for (int i = 0; i < 8; i++)
            graph.addNode(i);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(3,4);
        graph.addEdge(5,7);
        graph.addEdge(5,6);
        graph.addEdge(6,7);
        graph.addEdge(7,2);

        this.run();
    }

    private void run() {
        HashMap<Node, Integer> inwardEdges = new HashMap<>();
        for(Node node : graph.getAdjNodes().keySet())
            inwardEdges.put(node, 0);

        for(Node node : graph.getAdjNodes().keySet()) {
            List<Node> adjNodes = graph.getAdjNodes().get(node);

            for(Node adjNode : adjNodes) {
                int e = inwardEdges.get(adjNode);
                inwardEdges.replace(adjNode, e+1);
            }
        }

        Node src = new Node(Integer.MIN_VALUE);

        for (Node node : inwardEdges.keySet()) {
            System.out.println(node.label + " " + inwardEdges.get(node));
            if (inwardEdges.get(node) != 0)
                continue;
            src = node;

            System.out.println("src: " + src.label);

            LinkedList<Node> queue = new LinkedList<>();
            Stack<Node> stack = new Stack<>();
            HashMap<Node, Boolean> visited = new HashMap<>();
            queue.addLast(src);
            visited.put(src, true);
            while (!queue.isEmpty()) {
                src = queue.removeFirst();
                stack.push(src);
                for (Node adjNode : graph.getAdjNodes(src.label)) {
                    if (!visited.containsKey(adjNode)) {
                        queue.addLast(adjNode);
                        visited.put(adjNode, true);
                    }
                }
            }

            System.out.println("Build Order: ");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop().label + " ");
            }
            System.out.println();

        }
        if (src.label == Integer.MIN_VALUE)
            System.out.println("Build graph not possible!");

    }
}
