package leetcode;

/**
 * 动态规划，和62很像，多了一些限制条件
 */
class UniquePathsWithObstacles {

    public void solution(){
//        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] obstacleGrid = {{0,0},{1,1},{0,0}};
//        System.out.println(obstacleGrid.length);
        System.out.println(uniquePaths_opt(obstacleGrid));
    }

    public int uniquePaths_rec(int m, int n) {

        return 0;
    }

    public int uniquePaths_opt(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] dp = new int[n][m];

        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            dp[0][i] = obstacleGrid[0][i] == 1 ? 0 : dp[0][i-1];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i-1][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n-1][m-1];
    }


    public static void main(String[] args) {
        UniquePathsWithObstacles m = new UniquePathsWithObstacles();
        m.solution();
    }
}