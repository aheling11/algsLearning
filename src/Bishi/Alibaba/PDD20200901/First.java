package Bishi.Alibaba.PDD20200901;

import java.util.Scanner;
public class First {
    /**
     * n = 6
     * 0 2 2 1 1 0
     * 3 0 2 1 0 8
     * 3 3 0 0 8 8
     * 4 4 0 0 7 7
     * 4 0 5 6 0 7
     * 0 5 5 6 6 0
     *
     * 0 2 1 0
     * 3 0 0 8
     * 4 0 0 7
     * 0 5 6 0
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] nums = new int[n][n];
        int flag = 1;
        if((n & 1) == 1) flag = 0;

            for(int i = 0; i < n/2 - flag; i++){
                for (int j = n/2 + (1 - flag); j < n - 1 - i; j++) {
                    nums[i][j] = 1;
                }
                for (int j = n/2 - 1; j > i; j--) {
                    nums[i][j] = 2;
                }
            }
            for(int j = 0; j < n/2 - flag; j++){
                for (int i = n/2 - 1; i > j ; i--) {
                    nums[i][j] = 3;
                }
                for (int i = n/2 + (1 - flag); i < n - 1 - j ; i++) {
                    nums[i][j] = 4;
                }
            }
            for(int i = n - 1; i > n/2; i--){
                for (int j = n/2 - 1; j > n - 1 - i; j--) {
                    nums[i][j] = 5;
                }
                for (int j = n/2 + 1 - flag; j < i; j++) {
                    nums[i][j] = 6;
                }
            }
            for(int j = n - 1; j > n/2; j--){
                for (int i = n/2 - 1; i > n - 1 - j ; i--) {
                    nums[i][j] = 8;
                }
                for (int i = n/2 + 1 -flag; i < j ; i++) {
                    nums[i][j] = 7;
                }
            }

        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }
}