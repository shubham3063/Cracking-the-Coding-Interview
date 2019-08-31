import java.util.ArrayList;

public class Solutions {
    Solutions() {
        run();
    }

    private void run() {
        // 01 INSERTION
//        int N = 673; // 1010100001
//        int M = 13;  // 1101
//        int i = 1, j = 4;
//        System.out.println(Integer.toBinaryString(insertion(M,N,i,j)));

        // 02 BINARY TO STRING : ERROR
//        double D = 0.72;
//        System.out.println(getBinaryOfReal0To1(D));

        // 03 Flip bit to win
//        System.out.println(getMaxLength(3535));
//        System.out.println(getMaxLength(1775));

        // 04 Next Number
//        System.out.println(nextNumber(10));
//        System.out.printlnn(prevNumber(17));

        // 05 Debugger: n & (n-1) == 0 checks if the number is a power of 2.

        // 06 Conversion: XOR and count # 05 Debuggers
        System.out.println(conversion(16, 15));

        // 07 Pairwise Swap: mask for even places = GP of odd power of 2
        System.out.println(pairwiseSwap(200));
    }

    int pairwiseSwap(int n) {
        int m = (int) ((Math.pow(2,30) - 1) / 3);
        System.out.println(m + " " + Integer.toBinaryString(m));
        return ((n & m) << 1) | ((n & (m << 1)) >> 1);
    }

    int conversion(int a, int b) {
        int x = a ^ b;
        int cnt = 0;
        while (x > 0) {
            x = x & (x-1);
            cnt++;
        }
        return cnt;
    }

//    private int maxLength(int n) {
//
//    }

    int prevNumber(int n) {
        int m;
        m = ~n;
        int i = (int) (Math.log(m & (~m + 1)) / Math.log(2));
        m = ~m;
        m >>= i;
        int j = (int) (Math.log(m & (~m + 1)) / Math.log(2));
        n = n | (1 << (j-1 + i));
        n = n & ~(1 << (j + i));
        return n;
    }

    int nextNumber(int n) {
        int m = n;
        int i = (int) (Math.log(n & (~n + 1)) / Math.log(2));
        n >>= i; // remove all zeros
        n = ~n;  // get first zero by negating it
        int j = (int) (Math.log(n & (~n + 1)) / Math.log(2));
        n = ~n;
        n = n | (1 << j); // set bit at first zero
        n = n & ~(1 << j-1); // clear bit one position before zero
        n <<= i; // get back original n
        return n;
    }

    int getMaxLength(int n) {
        int currCnt = 0, prevCnt = 0, maxSoFar = 0;
        boolean flagLastBit = true;
        while (n > 0 || flagLastBit) {
            if (n == 0)
                flagLastBit = false;
            int b = n & 1;
            if (b == 0) { // if the current bit is 0
                if (currCnt > 0) {
                    int len = currCnt + prevCnt;
                    if (len > maxSoFar)
                        maxSoFar = len;
                    prevCnt = currCnt;
                    currCnt = 0;
                } else {
                    prevCnt = 0;
                }
            } else { // if the current bit is 1
                currCnt++;
            }
            n = n >> 1;
        }
        return maxSoFar + 1;
    }

    private int insertion(int M, int N, int i, int j) {
        int mask = ~(((1 << j+1) - 1) ^ ((1 << i) - 1));
        System.out.println(Integer.toBinaryString(mask));
        int res  = N & mask;
        System.out.println(Integer.toBinaryString(res));
        System.out.println(Integer.toBinaryString(M));
        return res | (M << i);
    }

    private String getBinaryOfReal0To1(double n) {

        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            System.out.println(n);
            if (stringBuilder.length() >= 32)
                return "ERROR";
            double r = n * 2;
            if (r >= 1) {
                stringBuilder.append(1);
                n = r - 1;
            } else {
                stringBuilder.append(0);
                n = r;
            }
        }
        return stringBuilder.toString();
    }
}
