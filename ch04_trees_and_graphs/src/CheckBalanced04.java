public class CheckBalanced04 {
    Tree1 tree;
    boolean flagIsBalanced;
    CheckBalanced04() {
        this.tree = new Tree1();
        this.flagIsBalanced = true;
        this.tree.createTreeFromArray();

        Result res = checkBalanced(tree.getRoot());
        System.out.println("Height : " + res.h);
        System.out.println("isBalanced : " + res.isBalanced);
    }

    private Result checkBalanced(TreeNode node) {
        if (node == null) return new Result(0, true);
        Result resLeft = checkBalanced(node.left);
        Result resRight = checkBalanced(node.right);
        if (!resLeft.isBalanced || !resRight.isBalanced) {
            return new Result(-1, false);
        } else {
            boolean isCurrNodeBalanced = Math.abs(resLeft.h - resRight.h) > 1 ? false : true;
            int currNodeheight = Math.max(resLeft.h, resRight.h) + 1;
            return new Result(currNodeheight, isCurrNodeBalanced);
        }
    }

}

class Result {
    int h;
    boolean isBalanced;
    Result(int h, boolean isBalanced) {
        this.h = h;
        this.isBalanced = isBalanced;
    }
}