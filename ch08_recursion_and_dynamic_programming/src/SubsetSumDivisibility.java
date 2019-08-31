public class SubsetSumDivisibility {
    int[] A = {3,1,7,5};
    int m;
    public SubsetSumDivisibility() {
        m = 5;
    }
    private boolean isSumDiv(int sum, int[] A, int n, int m) {
        if (n == A.length)
            return false;
        int rem;
        if (sum != 0) {
            rem = sum % m;
            if (rem == 0)
                return true;
        }
        isSumDiv(sum+A[n], A, n+1, m);
    }
}
