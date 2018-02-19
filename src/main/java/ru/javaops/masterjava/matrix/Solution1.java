package ru.javaops.masterjava.matrix;

public class Solution1 {
    private static final int MATRIX_SIZE = 10;
    //всегда умножаем две квадратные матрицы, строку на столбец, проверки не требуется

    public static void main(String[] args) {
        final int[][] matrixA = {{0,1,2,3,4},{0,1,2,3,4},{0,1,2,3,4},{0,1,2,3,4},{0,1,2,3,4}};
        final int[][] matrixB = MatrixUtil.create(MATRIX_SIZE);
        for (int[] aMatrixA : matrixA) {
            for (int j = 0; j < matrixA.length; j++) {
                System.out.print(aMatrixA[j] + " ");
            }
            System.out.println();
        }
    }
    public static void multiply(int[][] matrixA, int[][] matrixB ){
       for (int i=0; i<matrixA.length; i++){
           for (int j=0; j<matrixA.length; j++){

           }
       }
    }
    public static int[][] transpon(int[][] matrix){
        int[][] newMatrix = new int[matrix.length][matrix.length];

        return new int[10][10];
    }
}
