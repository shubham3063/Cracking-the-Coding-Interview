import java.util.HashMap;

public class OneAway05 {
    private String srcStr, dstStr;
    OneAway05(String srcStr, String dstStr){
        this.srcStr = srcStr;
        this.dstStr = dstStr;
        System.out.println("Running oneAway...");
        this.run();
        System.out.println("---------------------");
    }
    public void run(){
        System.out.println(this.oneAwayHashMap());
    }

    private HashMap<Character, Integer> buildHashMap(String str) {
        HashMap <Character, Integer> hashMap = new HashMap<>();
        for (char ch :
                str.toCharArray()) {
            if (hashMap.containsKey(ch)) {
                int v = hashMap.get(ch) + 1;
                hashMap.put(ch, v);
            } else {
                hashMap.put(ch, 1);
            }
        }
        return hashMap;
    }

    private boolean oneAwayHashMap(){
        // build hashmaps
        HashMap<Character, Integer> srcStrHashMap = buildHashMap(srcStr);
        HashMap<Character, Integer> dstStrHashMap = buildHashMap(dstStr);

        // compare hashmaps
        // find keys which are equal
        int commonKeyDist = 0, keyNotInDstDist = 0, keyNotInSrcDist = 0;
        for (char srcKey: srcStrHashMap.keySet()) {
            if(dstStrHashMap.containsKey(srcKey)) {
                commonKeyDist += Math.abs(srcStrHashMap.get(srcKey) - dstStrHashMap.get(srcKey));
            } else {
                keyNotInDstDist += srcStrHashMap.get(srcKey);
            }
        }
        for (char dstKey: dstStrHashMap.keySet()) {
            if(!srcStrHashMap.containsKey(dstKey))
                keyNotInSrcDist += dstStrHashMap.get(dstKey);
        }
        // for one distance away,
        // insertion and deletion: common dist + non-common dist <= 1
        // replacement: common dist == 0, non-common dist == 2 (equivalent to 1 edit)
        if(commonKeyDist + keyNotInDstDist + keyNotInSrcDist <= 1) return true;
        else if(commonKeyDist == 0 && keyNotInDstDist == 1 && keyNotInSrcDist == 1) return true;
        return false;
    }
}
