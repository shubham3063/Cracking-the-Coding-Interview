import java.util.Arrays;
import java.util.HashMap;

public class CheckPermutation02 {
    String inpStr1, inpStr2;
    CheckPermutation02(String inpStr1, String inpStr2){
        this.inpStr1 = inpStr1;
        this.inpStr2 = inpStr2;
        System.out.println("Running checkPermutations...");
        this.run();
        System.out.println("---------------------");

    }
    public void run(){
        if(inpStr1.length() != inpStr2.length()){
            System.out.println("String lengths unequal! Exiting...");
            return;
        }

        System.out.println("Naive: (incorrect why?) " + checkPermNaive());
        System.out.println("Sorting: " + checkPermSorting());
        System.out.println("HashMap: " + checkPermHashMap());
    }

    private boolean checkPermNaive() {
        for (char ch : inpStr1.toCharArray()) {
            if (inpStr2.indexOf(ch)==-1){
                return false;
            }
        }
        return true;
    }

    private String sort(String s){
        char[] content = s.toCharArray();
        Arrays.sort(content);
//        return content.toString();
        return new String(content);
    }
    private boolean checkPermSorting() {
        return sort(inpStr1).equals(sort(inpStr2));
    }

    private boolean checkPermHashMap() {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char ch :
                inpStr1.toCharArray()) {
            if (hashMap.containsKey(ch)) {
                int v = hashMap.get(ch);
                hashMap.put(ch, v + 1);
            }
            else {
                hashMap.put(ch, 1);
            }
        }
        for (char ch :
                inpStr2.toCharArray()) {
            if (!hashMap.containsKey(ch))
                return false;
            else if(hashMap.get(ch)==0)
                return false;
            int v = hashMap.get(ch);
            hashMap.put(ch, v-1);
        }
        return true;
    }
}
