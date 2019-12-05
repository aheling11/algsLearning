package leetcode;

class UniquePaths {

    public void solution(){
        System.out.println(uniquePaths_opt(7, 3));
    }

    public int uniquePaths_rec(int m, int n) {

        if (n == 1) {
            return 1;
        }
        if (m == 1) {
            return 1;
        }
        return uniquePaths_rec(m - 1, n) + uniquePaths_rec(m, n -1);
    }

    public int uniquePaths_opt(int m, int n) {
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i < n + 1; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i < m + 1; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < n + 1; i++) {
            for (int j = 2; j < m + 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n][m];
    }


    public static void main(String[] args) {
        UniquePaths m = new UniquePaths();
        m.solution();
    }
}