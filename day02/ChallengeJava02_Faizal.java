package day02;

public class ChallengeJava02_Faizal {
    public static void main(String[] args) {
        //Challenge Array

        //OrderEvenBeforeOdd
        //int[] storage = {7, 2, 6, 8, 1, 9, 3, 4};
        //displayArray(orderEvenBeforeOdd(storage));

        //IsPalindrome
        //String[] myString = {"is","am","are"};
        //System.out.println(isPalindromString(myString));

        //AddOnePlus
        //int[] storage = {4, 1, 0, 9};
        //displayArray(addOnePlus(storage));

        //Challenge Matrix

        //displayMatrix(matrixNo1(4,4));
        //displayMatrix(matrixNo2(7,7));
        //displayMatrix(matrixNo3(11));
        //displayMatrix(matrixNo4(6));

    }
    public static void displayArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void displayMatrix(int[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%3d ", matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static int[] orderEvenBeforeOdd(int[] arr){
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            while (left < right && arr[left] % 2 == 0) {
                left++;
            }
            while (left < right && arr[right] % 2 != 0) {
                right--;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        for (int i = 0; i < left - 1; i++) {
            for (int j = 0; j < left - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = left; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static boolean isPalindromString(String[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - i - 1]){
                return false;
            }
        }
        return true;
    }

    public static int[] addOnePlus(int[] arr){
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < 9) {
                arr[i]++;
                return arr;
            }
            arr[i] = 0;
        }
        int[] result = new int[arr.length + 1];
        result[0] = 1;
        return result;
    }

    public static int[][] matrixNo1(int n, int m){
        int[][] matrix = new int[n][m];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(row == col){
                    matrix[row][col] = row+1;
                } else if (row > col) {
                    matrix[row][col] = 20;
                } else {
                    matrix[row][col] = 10;
                }
            }
        }
        return matrix;
    }

    public static int[][] matrixNo2(int n, int m){
        int[][] matrix = new int[n][m];
        int counter = n;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(row == col){
                    matrix[row][col] = counter;
                    counter--;
                } else if (row > col) {
                    matrix[row][col] = 10;
                } else {
                    matrix[row][col] = 20;
                }
            }
        }
        return matrix;
    }

    public static int[][] matrixNo3(int n){
        int[][] matrix = new int[n][n];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(row == 0){
                    matrix[row][col] = col;
                } else if (col == 0) {
                    matrix[row][col] = row;
                } else if (row == matrix.length-1){
                    matrix[row][col] = row+col;
                } else if (col == matrix.length-1){
                    matrix[row][col] = row+col;
                }
            }
        }
        return matrix;
    }

    public static int[][] matrixNo4(int n){
        int[][] matrix = new int[n][n];
        for (int row = 0; row < matrix.length-1; row++) {
            for (int col = 0; col < matrix[row].length-1; col++) {
                matrix[row][col] = row + col;
                matrix[row][n-1] += matrix[row][col];;
                matrix[n-1][col] += matrix[row][col];;
            }
        }
        for (int i = 0; i < n-1; i++) {
            matrix[n-1][n-1] += matrix[n-1][i];;
        }
        return matrix;
    }
}