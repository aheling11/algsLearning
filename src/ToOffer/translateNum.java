package ToOffer;

import java.util.Hashtable;
import java.util.Stack;

class translateNum {
    public static int translateNum(int num) {
        String nums = String.valueOf(num);
        int[] dp = new int[12];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= nums.length(); i++) {
            int n = Integer.parseInt(nums.substring(i - 2, i));
            if (n < 26 && n > 10){
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[nums.length()];
    }

    public static void main(String[] args) {
        int num = 506;
        System.out.println(translateNum(num));
    }
}