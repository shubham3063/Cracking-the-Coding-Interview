public class RotateMatrix07 {
    private int[][] matrix;
    private int n;

    RotateMatrix07(int n) {
        this.n = n;
        this.matrix = new int[n][n];
        int cnt = 1;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                matrix[i][j] = cnt++;
            }
        }
        System.out.println("Running rotateMatrix...");
        this.run();
        System.out.println("---------------------");
    }

    private void run() {
        this.matrix = this.rotateMatrixTransposeFlip();
        printMatrix(this.matrix, matrix.length, matrix[0].length);
    }

    private int[][] rotateMatrixTransposeFlip() {
        transpose(matrix, n, n);
        flip(matrix, n, n);
        //printMatrix(matrix, matrix.length, matrix[0].length);
        return matrix;
    }

    private int getitself(int itself, int dummy) {
        return itself;
    }
    private void transpose(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = i+1; j < cols; j++) {
                matrix[i][j] = getitself(matrix[j][i], matrix[j][i] = matrix[i][j]);
            }
        }
    }

    private void flip(int [][] matrix, int rows, int cols) {
        for (int i=0; i < rows; i++) {
            for (int j = 0; j <= cols / 2; j++) {
                matrix[i][cols - j - 1] = getitself(matrix[i][j], matrix[i][j] = matrix[i][cols - j - 1]);
            }
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
