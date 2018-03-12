package ru.javaops.masterjava.matrix;

import org.openjdk.jmh.annotations.Benchmark;

import java.util.Random;

public class Solution1 {
    private static final int MATRIX_SIZE = 10;
    //всегда умножаем две квадратные матрицы, строку на столбец, результаты складываем это будет один элемент, проверки не требуется

    @Benchmark
    public  int [][] multiply(int[][] matrixA, int[][] matrixB ){
        int [][] result = new int [matrixA.length][matrixB.length];
        for (int i=0; i<matrixA.length; i++){
            for (int j=0; j<matrixB.length; j++){
                    for(int k=0;k<matrixA.length;k++){
                        result[i][j] += matrixA[i][k]*matrixB[k][j];
                    }
            }
        }
        return result;
    }
    public  void printMatrix(int [][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                System.out.print(matrix[i][j] +", ");
            }
            System.out.println();
        }
    }
    public  int [][] transponeMatrix(int [][] matrix){
        int [][] nMatrix = new int[matrix.length][matrix.length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                nMatrix[i][j] = matrix[j][i];
            }
        }
        return nMatrix;
    }
    public  int [][] createMatrix(int rows){
        Random random = new Random();
        int [][] matrix = new int[rows][rows];
        for(int i =0; i<rows; i++){
            for (int j=0; j<rows; j++){
                matrix[i][j] = random.nextInt(100000);
            }
        }
        return matrix;
    }
}
