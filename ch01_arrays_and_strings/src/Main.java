import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        // INPUTS
        Scanner scanner = new Scanner(System.in);
//        String inpStr = scanner.nextLine();
        String inpStr = new String("shubham");
        String inpStr2 = new String("hsubmaa");
        String inpStr3 = new String("My name is Shubham      ");
        String inpStr4 = new String("Tct Coooaaa"); // tacoo aocat
        String inpStr5 = new String("pales");
        String inpStr6 = new String("bales");
        String inpStr7 = new String("aabcccdddd");
        int[][] M = {{1,2,3,4}, {5,0,6,7}, {8,9,10,0}};
        String inpStr8 = new String("ashubh");

        // Q.01 Is Unique
        IsUnique01 isUnique01 = new IsUnique01(inpStr);

        // Q.02 Check Permutation
        CheckPermutation02 checkPermutation02 = new CheckPermutation02(inpStr,inpStr2);


        // Q.03 Urify
        char [] uri = inpStr3.toCharArray();
        Urify03 urify03 = new Urify03(uri, 18);


        // Q.04 Palindrome Permutation
        PalindromePermutation04 palindromePermutation04 = new PalindromePermutation04(inpStr4);

        // Q.05 One Away
        OneAway05 oneAway05 = new OneAway05(inpStr5, inpStr6);

        // Q.06 String Compression
        StringCompression06 stringCompression06 = new StringCompression06(inpStr7);

        // Q.07 Rotate Matrix
        RotateMatrix07 rotateMatrix07 = new RotateMatrix07(5);

        // Q.08 Zero Matrix
        ZeroMatrix08 zeroMatrix08 = new ZeroMatrix08(M, M.length, M[0].length);

        // Q.09 String Rotation
        StringRotation09 stringRotation09 = new StringRotation09(inpStr, inpStr8);

    }
}
