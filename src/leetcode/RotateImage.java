package leetcode;

import edu.princeton.cs.algs4.StdOut;

public class RotateImage {

    public static void rotate(int[][] matrix) {
        int n = matrix[0].length;
        for (int k = 0; k < n/2; k++) {
            int[] help = new int[n-1-2*k];

            for (int i = 0; i < n-1-2*k; i++) {
                help[i] = matrix[i+k][n-1-k];
                matrix[i+k][n-1-k] = matrix[k][i+k];
                matrix[k][i+k] = matrix[n-1-i-k][k];
                matrix[n-1-i-k][k] = matrix[n-1-k][n-1-i-k];
            }


            int j = 0;
            for (int i = n-1-2*k; i > 0; i--) {
                matrix[n-1-k][i+k] = help[j++];
            }
        }
    }

    public static void rotate2(int[][] matrix) {
        int n = matrix[0].length;
        for (int k = 0; k < n/2; k++) {
            int temp;

            for (int i = 0; i < n-1-2*k; i++) {
                temp = matrix[i+k][n-1-k];
                matrix[i+k][n-1-k] = matrix[k][i+k];
                matrix[k][i+k] = matrix[n-1-i-k][k];
                matrix[n-1-i-k][k] = matrix[n-1-k][n-1-i-k];
            }



        }
    }


    public static void show(int[][] matrix) {
        int n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                StdOut.printf("%2d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int[][] matrix = new int[][]{{ 5, 1, 9,11},{2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};

        rotate(matrix);
        show(matrix);
    }
}
