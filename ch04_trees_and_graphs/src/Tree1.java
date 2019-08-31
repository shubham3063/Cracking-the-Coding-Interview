class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class Tree1 {

    private TreeNode root;

    public Tree1() { }

    public void createTreeFromArray() {
//        System.out.println("--------------------");
        int[] sortedNums = new int[20];
        for (int i = 0; i < sortedNums.length; i++) {
            sortedNums[i] = i;
//            System.out.print(sortedNums[i] + " ");
        }
//        System.out.println();
        this.root = this.genBst(sortedNums, 0, sortedNums.length-1);
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode genBst(int[] A, int l, int r) {
//        System.out.println(l + " "  + r);
        if (l > r) return null;
        if (l == r) return new TreeNode(A[l], null, null);
        int mid = l + (r - l) / 2;
        return new TreeNode(A[mid], genBst(A, l, mid-1), genBst(A, mid+1, r));
    }

    public void preorder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
}
