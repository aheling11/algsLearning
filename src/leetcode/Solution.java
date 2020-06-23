package leetcode;

/**
 * 面试题60. n个骰子的点数
 */
class Solution {
    public static double[] twoSum(int n) {
        int rows = n;
        int cols = n * 6;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < 6; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = i; j < cols; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k >= 0){
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
        }


        double[] result = new double[cols - n + 1];
        for (int i = 0; i < cols - n + 1; i++) {
            result[i] = dp[n - 1][n - 1 + i];
            result[i] /= Math.pow(6, n);
        }
        return result;
    }

    public static void main(String[] args) {
        twoSum(3);
    }
}