package leetcode;


import java.util.Arrays;

/**
 *
 * 1143. Longest Common Subsequence
 */
class longestCommonSubsequence {
    public int solution1(String text1, String text2) {
        return longestCommonSubsequence(text1, text2);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int n = chars1.length;
        int m = chars2.length;

        int[][] dp = new int[n][m];
        dp[0][0] = 0;
        if (chars1[0] == chars2[0]) {
            dp[0][0] = 1;
        }
        for (int i = 1; i < chars2.length; i++) {
            dp[0][i] = chars1[0] == chars2[i] ? 1 : dp[0][i-1];
        }
        for (int i = 1; i < chars1.length; i++) {
            dp[i][0] = chars2[0] == chars1[i] ? 1 : dp[i-1][0];
        }
        for (int i = 1; i < chars1.length; i++) {
            for (int j = 1; j < chars2.length; j++) {
                if (chars1[i] == chars2[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n - 1][m - 1];

    }




    public static void main(String[] args) {
        longestCommonSubsequence l = new longestCommonSubsequence();

        String text1 = "QRCRP";
        String text2 = "PQRC";

        int count = l.longestCommonSubsequence(text1, text2);
        System.out.println(count);
    }
}