import java.util.ArrayList;
import java.util.LinkedList;

public class Permutation {
    public Permutation() {
        int[] A = {1,2,3,4};
        print(iterativeNoDups(A));
    }

    private ArrayList<LinkedList<Integer>> iterativeNoDups(int[] A) {
        ArrayList<LinkedList<Integer>> set = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(A[0]);
        set.add(list);
        for (int i = 1; i < A.length; i++) {
            int n = set.size();
            for (int j = 0; j < n; j++) {
                LinkedList<Integer> l = set.get(j);
                int m = l.size();
                for (int k = 0; k <= m; k++) {
                    l.add(k,A[i]);
                }
                set.add(l);
            }
        }
        return set;
    }
    private void print(ArrayList<LinkedList<Integer>> set) {
        System.out.println("Length of set:" + set.size());
        for (LinkedList<Integer> subset: set){
            for (int item : subset) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
