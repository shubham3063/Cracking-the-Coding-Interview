import java.util.*;

public class ListOfDepth03 {
    private Tree1 tree;
    private Map<Integer, List<Integer>> depthList;
    private ArrayList<LinkedList<TreeNode>> depthListRecur;
    ListOfDepth03(){
        tree = new Tree1();
        tree.createTreeFromArray();
        System.out.println("Preorder traversal");
        tree.preorder(tree.getRoot());
        System.out.println();

        // iterative variable
        depthList = new HashMap<>();

        // recursive variable
        depthListRecur = new ArrayList<LinkedList<TreeNode>>();

        this.run();
    }

    private void run() {
        System.out.println("Solution 1: Iterative");

        getDepthLists();
        printDepthList();

        System.out.println("Solution 2: Recursive");
        createDepthList(tree.getRoot(), depthListRecur, 0);
        printDepthListRecur();
    }
    
    private void createDepthList(TreeNode node, ArrayList<LinkedList<TreeNode>> list, int level) {
        if (node == null) return;
        if (list.size() == level)
            list.add(new LinkedList<>());
        list.get(level).add(node);
        createDepthList(node.left, list, level+1);
        createDepthList(node.right, list, level+1);
    }
    
    
    private void getDepthLists() {
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> depth = new LinkedList<>();
        queue.push(tree.getRoot());
        depth.push(1);
        while (!queue.isEmpty()) {
            TreeNode t = queue.removeFirst();
//            System.out.println(t.data);
            int d = depth.removeFirst();
            if (!depthList.containsKey(d))
                depthList.put(d, new ArrayList<>());
            depthList.get(d).add(t.data);

            if (t.left != null) {
//                System.out.println("left: " + t.left.data);
                queue.addLast(t.left);
                depth.addLast(d + 1);
            }
            if (t.right != null) {
//                System.out.println("right: " + t.right.data);
                queue.addLast(t.right);
                depth.addLast(d + 1);
            }
        }
    }

    private void printDepthList() {
        for (int depth : depthList.keySet()) {
            System.out.print(depth + " : ");
            List<Integer> nodesAtDepth = depthList.get(depth);
            for (int j = 0; j < nodesAtDepth.size(); j++) {
                System.out.print(nodesAtDepth.get(j) + " ");
            }
            System.out.println();
        }
    }
    private void printDepthListRecur() {

        for (int i = 0; i < depthListRecur.size(); i++) {
            System.out.print(i + " : ");
            for (TreeNode node :
                    depthListRecur.get(i)) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
    }

}
