package leetcode;

/**
 * 5. 最长回文子串
 */
class longestPalindrome {
    /**
     * 1.暴力法
     * @param s
     * @return
     */
    public static String longestPalindrome_brute(String s) {
        if (s == null || s.length() <= 1){
            return s;
        }
        String res = s;
        for(int size = 1; size <= s.length(); size++){
            for(int i = 0; i < s.length(); i++){
                if(count(s, i, i + size - 1)){
                    res = s.substring(i, i + size);
                    break;
                }
            }
        }
        return res;
    }

    private static boolean count(String s, int start, int end){
        if(end >= s.length()) return false;
        while(end > start){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            end--;
            start++;
        }
        return true;
    }

    /**
     * 2.dp方法
     * @param s
     * @return
     */
    public static String longestPalindrome_dp(String s) {
        if (s == null || s.length() <= 1){
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] chars = s.toCharArray();
        int start = 0;
        int maxLen = 0;
        for(int j = 0; j < s.length(); j++){
            for(int i = 0; i <= j; i++){
                if (chars[i] != chars[j]){
                    dp[i][j] = false;
                } else {
                    if (j - i < 3){
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen){
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
    public static void main(String[] args) {
        String s = "adcacdda";
        System.out.println(longestPalindrome_dp(s));
    }
}