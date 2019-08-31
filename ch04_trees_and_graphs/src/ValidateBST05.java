import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;

public class ValidateBST05 {
    Tree1 tree;

    TreeNode prev;

    ValidateBST05() {
        this.tree = new Tree1();
        this.tree.createTreeFromArray();


        ArrayList<Integer> A = new ArrayList<>();
        saveInorderBST(this.tree.getRoot(), A);
        int p = A.get(0);
        boolean flagCheckBST = true;
        for(int i=1; i<A.size(); i++) {
            System.out.print(A.get(i) + " ");
            if (p >= A.get(i)) {
                flagCheckBST = false;
            }
        }
        System.out.println();

        System.out.println("CheckBST Inorder with Array: " + flagCheckBST);

        this.prev = null;
        System.out.println("CheckBST Inorder without Array: " + checkBST(tree.getRoot()));

//        ResultValBST res = isBST(tree.getRoot());
//        System.out.println("isBST min max: " + res.flagIsBST);
        System.out.println("CheckBST Min Max: " + checkBSTMinMax(this.tree.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE));

    }

    private void saveInorderBST(TreeNode node, ArrayList<Integer> A) {
        if (node == null) return;
        saveInorderBST(node.left, A);
        A.add(node.data);
        saveInorderBST(node.right, A);
    }

    private boolean checkBST(TreeNode node) {
        if (node == null) return true;
        if (checkBST(node.left) == false) return false;
        if (prev != null && prev.data >= node.data)
            return false;
        prev = node;
//        System.out.println(node.data + " ");
        if (checkBST(node.right) == false) return false;
        return true;
    }

    private boolean checkBSTMinMax(TreeNode node, int i, int j) {
        if (node == null)
            return true;
        if (!(node.data >= i && node.data <= j))
            return false;
        if (!checkBSTMinMax(node.left,i,node.data))
            return false;
        if (!checkBSTMinMax(node.right,node.data+1, j))
            return false;
        return true;
    }

    private ResultValBST isBST(TreeNode node) {
        if (node == null)
            return new ResultValBST(Integer.MAX_VALUE, Integer.MIN_VALUE, true);

        ResultValBST resLeft = isBST(node.left);
        ResultValBST resRight = isBST(node.right);

        if (!resLeft.flagIsBST || !resRight.flagIsBST)
            return new ResultValBST(Integer.MAX_VALUE, Integer.MIN_VALUE, false);

        int leftMax = resLeft.maxVal;
        int rightMin = resRight.minVal;

        if (node.data >= leftMax && node.data < rightMin) {
            return new ResultValBST(rightMin, leftMax, true);

        } else {
            return new ResultValBST(rightMin, leftMax, false);
        }
    }

}


class ResultValBST {
    int minVal;
    int maxVal;
    boolean flagIsBST;
    ResultValBST (int minVal, int maxVal, boolean flagIsBST)
    {
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.flagIsBST = flagIsBST;
    }
}

