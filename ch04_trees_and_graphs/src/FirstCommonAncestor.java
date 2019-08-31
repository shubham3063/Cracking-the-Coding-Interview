import java.util.LinkedList;
import java.util.ListIterator;

public class FirstCommonAncestor {
    private Tree1 tree;
    private TreeNode node1, node2;
    FirstCommonAncestor() {
        tree = new Tree1();
        tree.createTreeFromArray();
        tree.inorder(tree.getRoot());
        node1 = tree.getRoot().left.left.left;
        node2 = tree.getRoot().left.left.right;
        System.out.println("node1: " + node1.data);
        System.out.println("node2: " + node2.data);
        this.run();
    }
    private void run() {
        LinkedList<TreeNode> path1 = new LinkedList<>();
        LinkedList<TreeNode> path2 = new LinkedList<>();
        searchItem(tree.getRoot(), node1, path1);
        searchItem(tree.getRoot(), node2, path2);

        for (TreeNode node : path1) {
            System.out.print(node.data +  " ");
        }
        System.out.println();
        for (TreeNode node : path2) {
            System.out.print(node.data + " ");
        }
        System.out.println();
        TreeNode commonAncestor = tree.getRoot();
        ListIterator<TreeNode> iter1 = path1.listIterator();
        ListIterator<TreeNode> iter2 = path2.listIterator();
        while (iter1.hasNext() && iter2.hasNext()) {
            TreeNode node1 = iter1.next();
            TreeNode node2 = iter2.next();
            System.out.println(node1.data + " " + node2.data);
            if (node1 != node2)
                break;
        }
    }

    private boolean searchItem(TreeNode node, TreeNode searchNode, LinkedList<TreeNode> path) {
        if (node == null) return false;
        path.addLast(node);
        if (node == searchNode) return true;
        boolean foundInLeft  = searchItem(node.left, searchNode, path);
        boolean foundInRight = searchItem(node.right, searchNode, path);
        if (!(foundInLeft || foundInRight)) {
            path.removeLast();
            return false;
        } else return true;
    }
}
