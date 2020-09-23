package Bishi.Alibaba.PDD20200901;

import java.util.Scanner;

public class Second {
    /**
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] c = new int[n + 1];
        int[] v = new int[n + 1];
        int k = 1;
        while (in.hasNextInt()){
            c[k] = in.nextInt();
            v[k] = in.nextInt();
            k++;
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(j < c[i]){
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c[i]] + v[i]);
                }
            }
        }

        System.out.println(dp[n][m]);

    }
}