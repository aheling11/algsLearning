package leetcode;

import utils.Utils;

class rotate {
    public static void rotate(int[][] matrix) {
        int n = matrix[0].length;
        for(int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        int mid = n >> 1;
        for(int i = 0; i < n; i++){
            for (int j = 0; j < mid; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for (int[] ints : matrix) {
            for (int item : ints) {
                System.out.print(item + " ");
            }
            System.out.println();
        }


    }
}