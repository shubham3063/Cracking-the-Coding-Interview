public class StringRotation09 {
    private String inpStr1, inpStr2;

    StringRotation09(String inpStr1, String inpStr2) {
        this.inpStr1 = inpStr1;
        this.inpStr2 = inpStr2;

        System.out.println("Running stringRotation...");
        this.run();
        System.out.println("---------------------");


    }

    private void run(){
        System.out.println(isStringRotation());
    }

    private boolean isStringRotation() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(inpStr1);
        stringBuilder.append(inpStr1);
        String concatStr = stringBuilder.toString();
        if(concatStr.contains(inpStr2)) return true;
        else return false;
    }
}
