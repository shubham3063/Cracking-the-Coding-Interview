import java.util.*;


public class Main {

    public static void main(String[] args) {
        new PowerSet();
    }

    private static void print(HashSet<ArrayList<Integer>> set) {
        for (ArrayList<Integer> list: set) {
            for (int a : list) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    private static void createPowerSetBinary() {
        int[] A = {5,4,6,2,3,1,7};
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<>();
        int lastSetNum = (int) Math.pow(2, A.length);
        for (int i = 0; i < lastSetNum; i++) {
            int n = i;
            while (n > 0) {
                int pos = (int) (Math.log((n & (n-1)) ^ n) / Math.log(2));
//                System.out.println(pos);
                list.add(A[pos]);
                n--;
            }
            set.add(list);
            list.clear();
        }
        print(set);
    }

    private static void createPowerSetRecursion() {
        int[] A = {5,4,6,2,3,1,7};
        Stack<Integer> S = new Stack<>();
        powerset(A,0, S);
    }

    private static void printArrayList(ArrayList<Integer> S) {
        for (int element : S) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    private static void print(Stack<?> S) {
        while (!S.isEmpty()) {
            System.out.print(S.pop() + " ");
        }
        System.out.println();
    }
    private static void powerset(int[] A , int n, Stack<Integer> S) {

        if (n == A.length) {
            print((Stack<?>)S.clone());
            return;
        }
        powerset(A,n+1,S);
        S.push(A[n]);
        powerset(A,n+1,S);
        S.pop();
    }

    private static void magicIdx() {
        int[] A = {-1, 0, 1, 2, 5, 5, 9, 10, 12};
        magicIdxDistinctNums(A, 0, A.length);
    }


    private static void magicIdxDistinctNums(int[] A, int l, int r) {
        if (l > r) return;
        int mid = l + (r - l) / 2;
        if (A[mid] == mid) {
            System.out.println(mid);
            return;
        }
        if (A[mid] > mid)
            magicIdxDistinctNums(A, l, mid - 1);
        else
            magicIdxDistinctNums(A, mid + 1, r);
    }

    private static void toh(int n, int i, int j, int k) {
        if (n == 1) {
            System.out.println("Move " + n + " from " + i + " to " + k);
            return;
        }
        toh(n-1, i, k, j);
        System.out.println("Move " + n + " from " + i + " to " + k);
        toh(n-1, j, i, k);
    }

}
