package leetcode;

/**
 * 5. 最长回文子串
 */
class longestPalindrome {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1){
            return "";
        }
        char[] arr = s.toCharArray();
        int n = s.length();
        int[][] dp = new int[n][n];
        int max = -1;
        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for(int k = 1; k < n; k++){
            int i = k;
            int j = 0;
            while(i < n){
                if (i - j== 1 && arr[i] == arr[j]){
                    dp[i][j] = 1;
                }
                if (arr[j] == arr[i] && dp[j+1][i-1] == 1){
                    if (i - j + 1 > max){
                        max = i - j + 1;
                        start = j;
                        end = i;
                    }
                    dp[i][j] = 1;
                }
                i++;
                j++;
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}