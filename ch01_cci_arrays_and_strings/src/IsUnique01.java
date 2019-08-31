import java.util.Arrays;
import java.util.HashMap;

public class IsUnique01 {
    private String inputString;
    IsUnique01(String inputString){
        this.inputString = inputString;
        System.out.println("Running isUnique...");
        this.run();
        System.out.println("---------------------");
    }

    public void run(){

        boolean boolIsUniqueStr;
        boolIsUniqueStr = this.isUniqueNaive();
        System.out.println("Naive: " + boolIsUniqueStr);

        // hashmap implementation
        boolIsUniqueStr = this.isUniqueHashMap();
        System.out.println("HashMap: " + boolIsUniqueStr);

        // sorting based implementation without extra space
        boolIsUniqueStr = this.isUniqueSorting();
        System.out.println("Sorting: " + boolIsUniqueStr);

        // char set of ascii values used as hash map
        boolIsUniqueStr = this.isUniqueASCII();
        System.out.println("ASCII: " + boolIsUniqueStr);
    }

    public boolean isUniqueASCII(){
        boolean [] ascii = new boolean[128];
        for (char ch :
                inputString.toCharArray()) {
            if(ascii[(int)ch])
                return false;
            ascii[(int)ch] = true;
        }
        return true;
    }

    public boolean isUniqueSorting(){
        char[] sortedCharArray = inputString.toCharArray();
        Arrays.sort(sortedCharArray);
        char prev = ' ';
        for (char ch :
                sortedCharArray) {
            if (prev == ch){
                return false;
            }
            prev = ch;
        }
        return true;
    }

    public boolean isUniqueHashMap(){
        HashMap<Character,Boolean> hashMap = new HashMap<Character, Boolean>();
        for (char ch : inputString.toCharArray()) {
            if(hashMap.containsKey(ch)) {
                return false;
            }
            hashMap.put(ch,true);
        }
        return true;
    }

    public boolean isUniqueNaive(){
        for(int i=0; i<inputString.length(); i++) {
            for(int j=i+1; j<inputString.length(); j++) {
                if (inputString.charAt(i) == inputString.charAt(j))
                    return false;
            }
        }
        return true;
    }
}
