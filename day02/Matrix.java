package day02;

import java.util.Random;

public class Matrix {
    public static void main(String[] args) {
        /*var matriks2 = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        displayMatriks(matriks2);*/

        /*displayMatriks(fillMatriksRandom(5));*/

        displayMatriks(matrixSum(8));
    }

    public static int[][] fillMatriksRandom(int n) {
        int[][]matriks = new int[n][n];
        Random random = new Random();
        for (int row = 0; row < matriks.length; row++) {
            for (int col = 0; col < matriks[row].length; col++) {
                matriks[row][col] = random.nextInt(11);
            }
        }
        return matriks;
    }

    public static void initMatriks(){
        int[][] matriks = new int[2][2];
        matriks[0][1] = 10;
        var matriks2 = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
    }

    public static void displayMatriks(int[][] matriks){
        for (int row = 0; row < matriks.length; row++) {
            for (int col = 0; col < matriks[row].length; col++) {
                System.out.printf("%3d ", matriks[row][col]);
            }
            System.out.println();
        }
    }

    public static int [][] matrixDiagonal(int m, int n) {
        int[][]matrix = new int[m][n];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == col){
                    matrix[row][col] = row+1;
                }
                if (col > row){
                    matrix[row][col]=10;
                } else if (row > col){
                    matrix[row][col]=20;
                }
            }
        }
        return matrix;
    }

    public static int[][] matrixSum(int n){
        int[][] matrix = new int[n][n];
        for (int row = 0; row < n - 1; row++) {
            for (int col = 0; col < n - 1; col++) {
                matrix[row][col] = row + col;
                matrix[row][n-1] += matrix[row][col];
                matrix[n-1][row] += matrix[row][col];
            }
        }
        for (int i = 0; i < n - 1; i++) {
            matrix[n-1][n-1] += matrix[n-1][i];
        }
        return matrix;
    }
}
