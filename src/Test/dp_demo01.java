package Test;

import java.util.Arrays;

public class dp_demo01 {

    int[] arr = {3, 34, 4, 12, 5, 2};
    int n = 0;

    public dp_demo01(int n) {
        this.n = n;
    }

    public void solution() {
        System.out.println(dp_subset(9));
        System.out.println(dp_subset(13));
        System.out.println(dp_subset(15));

    }

    public boolean subset(int i, int s){
        if ( s == 0 ) {
            return true;
        } else if ( i == 0 ) {
            return arr[0] == s;
        } else if ( arr[i] > s) {
            return subset(i-1, s);
        }
        return subset(i-1, s-arr[i]) || subset( i-1, s );
    }

    public boolean dp_subset(int s) {
        boolean[][] dp = new boolean[n][s+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < s+1; i++){
            dp[0][i] = false;
        }
        dp[0][arr[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < s + 1; j++) {
                if (arr[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - arr[i]] || dp[i - 1][j];
                }

            }
        }

        return dp[n-1][s];
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void print2DArray(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }



    // 1 1 2 3 5 8 13
    public static void main(String[] args) {
        dp_demo01 f = new dp_demo01(6);
        f.solution();
    }

}
