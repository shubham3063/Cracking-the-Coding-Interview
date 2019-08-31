public class Urify03 {
    char[] uri;
    int nChars;
    Urify03 (char [] uri, int nChars){
        this.uri = uri;
        this.nChars = nChars;
        System.out.println("Running urify...");
        this.run();
        System.out.println("---------------------");
    }

    public void run(){
        System.out.println(UrifyNaive());
    }

    private String UrifyNaive() {
        int nSpaces = 0;
        for (int i = 0; i < nChars; i++) {
            if(uri[i] == ' ')
                nSpaces++;
        }
        int reqChars = nChars - nSpaces + 3*nSpaces;
        if(reqChars < uri.length) uri[reqChars] = '\0'; // ending if uri length is higher
        int i = reqChars-1;
        for (int j = nChars-1; j >= 0; j--) {
            if(uri[j] == ' ') {
                uri[i] = '0';
                uri[i-1] = '2';
                uri[i-2] = '%';
                i-=3;
            }
            else {
                uri[i] = uri[j];
                i--;
            }
        }
        return new String(uri);
    }
}
