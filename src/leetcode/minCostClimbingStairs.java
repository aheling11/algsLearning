package leetcode;

class minCostClimbingStairs {

    public void solution(){
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
        System.out.println(minCostClimbingStairs_opt(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < len + 1; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        return dp[len];
    }

    public int minCostClimbingStairs_opt(int[] cost) {
        int len = cost.length;
        int f0 = 0, f1 = 0;
        for (int i = 2; i < len + 1; i++) {
            int temp = Math.min(f0 + cost[i-2], f1 + cost[i-1]);
            f0 = f1;
            f1 = temp;
        }
        return f1;
    }

    public static void main(String[] args) {
        minCostClimbingStairs m = new minCostClimbingStairs();
        m.solution();
    }
}