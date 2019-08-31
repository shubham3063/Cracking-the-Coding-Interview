import java.util.HashMap;

public class ZeroMatrix08 {
    private int[][] M;
    private int rows, cols;
    ZeroMatrix08(int[][] M, int rows, int cols){
        this.M = M;
        this.rows = rows;
        this.cols = cols;

        System.out.println("Running zeroMatrix...");
        this.run();
        System.out.println("---------------------");
    }

    private void run(){
        this.zeroMatrixHashMap();
        printMatrix(this.M, this.rows, this.cols);
    }

    private void zeroMatrixHashMap() {
        HashMap<Integer,Integer> zeroSub = new HashMap<>();
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                if (this.M[i][j] == 0)
                    zeroSub.put(i,j);
            }
        }
        for (int R :
                zeroSub.keySet()) {
            int C = zeroSub.get(R);
            for (int i = 0; i < this.rows; i++)
                this.M[i][C] = 0;

            for(int j = 0; j < cols; j++)
                this.M[R][j] = 0;
        }

    }

    private void printMatrix(int[][] matrix, int rows, int cols){
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
