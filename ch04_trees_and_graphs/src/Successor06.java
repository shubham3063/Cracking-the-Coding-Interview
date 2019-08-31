import javax.swing.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;

public class Successor06 {
    Tree1 tree;
    Successor06 () {
        tree = new Tree1();
        init(tree);
        TreeNode root = tree.getRoot();
        TreeNode searchNode = root.right.left;
        int[] path = new int[10];
        int[] n = new int[1];
        searchItem(root, searchNode, path, 0, n);
        for (int i = 0; i <= n[0]; i++)
            System.out.print(path[i] + " ");
        System.out.println();
        System.out.println("---------");
        LinkedList<TreeNode> pathList = new LinkedList<>();
        if (searchItem(root, searchNode, pathList)) {
            for (TreeNode node : pathList) {
                System.out.print(node.data + " ");
            }
            System.out.println();
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

    private void searchItem(TreeNode node, TreeNode searchNode, int[] path, int idx, int[] n) {
        if (node == null)
            return;
//        System.out.println(node.data);
        path[idx] = node.data;
//        for (int i = 0; i <= idx; i++) {
//            System.out.print(path[i] + " ");
//        }
        System.out.println();
        if(node == searchNode) {
            System.out.println("found node");
            n[0] = idx;
            return;
        }
        searchItem(node.left,  searchNode, path, idx+1, n);
        searchItem(node.right, searchNode, path, idx+1, n);
    }

    private void init(Tree1 tree) {
        TreeNode root = new TreeNode(5, null, null);
        root.left     = new TreeNode(2, null, null);
        root.right    = new TreeNode(9, null, null);

        TreeNode node = root.left;
        node.left     = new TreeNode(1, null, null);
        node.right    = new TreeNode(3, null, null);

        node          = node.right;
        node.right    = new TreeNode(4, null, null);

        node          = root.right;
        node.left     = new TreeNode(7, null, null);

        node          = node.left;
        node.left     = new TreeNode(6, null, null);
        node.right    = new TreeNode(8, null, null);

        tree.setRoot(root);
    }

}
