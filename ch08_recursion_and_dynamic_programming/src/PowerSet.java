import java.util.ArrayList;

public class PowerSet {
    public PowerSet() {
        int[] A = {1,2,3,4,5};
//        iterative2(A);
//        bitIterative(A);

//        ArrayList<ArrayList<Integer>> set = new ArrayList<>();
//        set.add(new ArrayList<>());
////        recursive(A,0,set,0,set.size());
//        bitRecursive(A, 0, set);
//        print(set);

//        ArrayList<ArrayList<Integer>> set = new ArrayList<>();
//        set.add(new ArrayList<>());
//        bitRecursive(A, 0, set);
//        print(set);

        print(recursive2(A,0));

    }

    private void bitRecursive(int[] A, int n, ArrayList<ArrayList<Integer>> set) {
        if (n == (1 << A.length))
            return;
        ArrayList<Integer> subset = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if ((n & (1 << i)) > 0)
                subset.add(A[i]);
        }
        set.add(subset);
        bitRecursive(A, n+1, set);
    }

    private void bitIterative(int[] A) {
        ArrayList<ArrayList<Integer>> set = new ArrayList<>();
        int max = 1 << A.length;
        for (int i = 0; i < max; i++) {
            ArrayList<Integer> subset = new ArrayList<>();
            for (int j = 0; j < A.length; j++) {
                System.out.println("i:" + i + " j:" + j + " " + (i & (1 << j)));
                if ((i & (1 << j)) > 0) {
                    subset.add(A[j]);
                }
            }
            set.add(subset);
        }
        print(set);
    }

    private ArrayList<ArrayList<Integer>> recursive2(int[] A, int i) {
        ArrayList<ArrayList<Integer>> set;
        if (i == A.length) {
            set = new ArrayList<>();
            set.add(new ArrayList<>());

        } else {
            set = recursive2(A, i+1);
            int j = 0;
            int n = set.size();
            while (j < n) {
                ArrayList<Integer> subset = set.get(j);
                ArrayList<Integer> ss = (ArrayList<Integer>) subset.clone();
                ss.add(A[i]);
                set.add(ss);
                j++;
            }
        }
        return set;
    }

    private void recursive(int[] A, int i, ArrayList<ArrayList<Integer>> set, int j, int n) {
//        System.out.println(A[i] + " " + j);
        if (i == A.length)
            return;
        ArrayList<Integer> subset = (ArrayList<Integer>) set.get(j).clone();
        subset.add(A[i]);
        set.add(subset);
        if (j+1 < n)
            recursive(A,i,set,j+1, n);
        else
            recursive(A,i+1,set,0,set.size());
    }

    private void iterative2(int[] A) {
        ArrayList<ArrayList<Integer>> set = new ArrayList<>();
        set.add(new ArrayList<>());
        for (int i = 0; i < A.length; i++) {
            int n = set.size();
            int j = 0;
            while (j < n) {
                ArrayList<Integer> subset = (ArrayList<Integer>) set.get(j).clone();
                subset.add(A[i]);
                set.add(subset);
                j++;
            }
        }

        print(set);
        System.out.println("Size of set: "+set.size());
    }

    private void iterative(int[] A) {
        ArrayList<ArrayList<Integer>> set = new ArrayList<>();
        set.add(new ArrayList<Integer>());
        for (int i = 0; i < A.length; i++) {
            ArrayList<ArrayList<Integer>> s = new ArrayList<>();
            for (ArrayList<Integer> subset : set) {
                ArrayList<Integer> ss = (ArrayList<Integer>) subset.clone();
                ss.add(A[i]);
                s.add(ss);
            }
            set.addAll(s);
        }
        print(set);
        System.out.println("Size of set: "+set.size());
    }

    private void print(ArrayList<ArrayList<Integer>> set) {
        System.out.println("Length of set:" + set.size());
        for (ArrayList<Integer> subset: set){
            for (int item : subset) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
