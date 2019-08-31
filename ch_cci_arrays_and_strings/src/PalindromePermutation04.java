import java.util.HashMap;

public class PalindromePermutation04 {
    String inpStr;
    PalindromePermutation04 (String inpStr){
        this.inpStr = inpStr;
        System.out.println("Running palindromePermutation...");
        this.run();
        System.out.println("---------------------");
    }

    public void run() {
        System.out.println("HashMap: " + palinPermHashMap());
        System.out.println("BitVector: " + palinPermBitVector());
    }

    private boolean palinPermHashMap() {
        // looking at property of palindrome
        // count of all chars should even except for one odd
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char ch :
                inpStr.toCharArray()) {
            if (ch == ' ')
                continue;
            ch = Character.toLowerCase(ch);
            if (hashMap.containsKey(ch)) {
                int v = hashMap.get(ch);
                hashMap.put(ch, v + 1);
            } else {
                hashMap.put(ch, 1);
            }
        }
        int nOdd=0;
        for (int v :
                hashMap.values()) {
            if (v % 2 != 0) nOdd++;
        }
        if (nOdd > 1) return false;
        else return true;
    }

    private boolean palinPermBitVector() {
        // use bit manipulation to store hash of a char (assume all to be lowercase for palidrome)
        // each char shifts 1 by unique value
        // integer is 4 bytes long. signed int can store 31 values
        int bitHash = 0;
        for (char ch :
                inpStr.toCharArray()) {
            if (ch == ' ') continue;
            ch = Character.toLowerCase(ch);
            int shiftBy = ch - 'a';
            bitHash = bitHash ^ (1 << shiftBy);
        }

        // check that there is at most one 1 present in the bitHash
        if (bitHash == 0) return true;
        if ((bitHash & (bitHash - 1)) > 0) return false;
        else return true;

        // alternatively non-elegant solution to check at most one 1.
//        int nOnes = 0; // ones represent char appearing odd number of times
//        int j = 0;
//        while (j < 32) { // loop for 31 times as there are 31 bits in a signed int.
//            int shiftedInt = 1 << j;
//            if ((bitHash & shiftedInt) > 0)
//                nOnes++;
//            j++;
//        }
//        if(nOnes > 1) return false;
//        else return true;
    }
}
