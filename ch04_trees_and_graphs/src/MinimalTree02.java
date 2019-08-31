
public class MinimalTree02 {
    Tree1 tree = new Tree1();

    MinimalTree02() {
        System.out.println("--------------------");
        int[] sortedNums = new int[10];
        for (int i = 0; i < sortedNums.length; i++) {
            sortedNums[i] = i;
            System.out.print(sortedNums[i] + " ");
        }
        System.out.println();
        tree.setRoot(tree.genBst(sortedNums, 0, sortedNums.length-1));
        printTree();
    }

    private void printTree() {
        tree.preorder(tree.getRoot());
        System.out.println();
        tree.inorder(tree.getRoot());
        System.out.println();
    }
}
