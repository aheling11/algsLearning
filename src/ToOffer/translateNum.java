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

    /**
     * 2020年06月10日14:31:50
     * @param num
     * @return
     */
    public static int translateNum_try_2(int num) {
        String numstring = String.valueOf(num);
        int[] dp = new int[12];
        if (numstring.length() <= 1){
            return 1;
        }
        dp[0] = 1;
        dp[1] = 1;
        //dp[i] = dp[i-1]
        //        dp[i-1] + dp[i-2]   if( 10 <= susbtring(i-2,i) < 26 )
        for (int i = 2; i <= numstring.length(); i++) {
            int parseInt = Integer.parseInt(numstring.substring(i - 2, i));
            if (parseInt >= 10 && parseInt < 26){
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[numstring.length()];
    }

    public static void main(String[] args) {
        int num = 12;
//        System.out.println(translateNum(num));
        System.out.println(translateNum_try_2(num));
    }
}