import java.util.List;

public class RouteBetweenNodes {
    Graph graph;
    RouteBetweenNodes() {
        this.graph = new Graph();
        this.graph.init();
        this.run();
    }
    private void run() {
        int label1 = 3, label2 = 2;
        isRoutePresent(label1,label2);
    }

    private void isRoutePresent(int label1, int label2) {
        List<Node> path = graph.bfs(label1, label2);
        if (!path.isEmpty()) {
            System.out.print("Path from source " + label1 + " -> ");
            for (Node node : path)
                System.out.print(node.label + " ");
        }
        else
            System.out.print("No path to destination");
        System.out.println();

    }
}
