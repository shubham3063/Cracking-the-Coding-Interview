public class StringCompression06 {

    private String inpStr;

    StringCompression06(String inpStr){
        this.inpStr = inpStr;
        System.out.println("Running stringCompression...");
        this.run();
        System.out.println("---------------------");
    }

    private void run(){
        System.out.println(stringCompressionNaive());
    }

    private String stringCompressionNaive() {

        //        String inpStr = new String("abcd");
        boolean flagCompressString = false;
        for (int i = 1; i < inpStr.length(); i++) {
            if (inpStr.charAt(i) == inpStr.charAt(i - 1)) {
                flagCompressString = true;
                break;
            }
        }
        if (!flagCompressString) {
            //System.out.println(inpStr);
            return inpStr;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char prev = inpStr.charAt(0);
        int cnt = 1;
        for (int i = 1; i < inpStr.length(); i++) {
            char ch = inpStr.charAt(i);
            if (prev == ch) {
                cnt++;
            } else {
                stringBuilder.append(prev);
                stringBuilder.append(cnt);
                cnt = 1;
            }
            prev = ch;
        }
        stringBuilder.append(prev);
        stringBuilder.append(cnt);
//        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }
}