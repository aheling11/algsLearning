package Bishi.Alibaba.meituan;

import java.util.*;

public class Solution3 {

    /**
     * 时间限制： 3000MS
     * 内存限制： 589824KB
     * 题目描述：
     * 小团和小美正在玩一个填数游戏，这个游戏是给一个等式，其中有一些数被挖掉了，你需要向其中填数字，使得等式成立。
     *
     * 比如 ___+12=34，那么横线填的一定是22
     *
     * 现在，这个游戏到了最后一关，这一关的等式很奇特：_+_+_+...+_=n
     *
     * 这里可以填任意多个正整数（甚至可能是1个），只要这些数的和等于n即可。
     *
     * 但是，有一个额外的限制，填入的所有数必须小于等于k，大于等于1，填入的数的最大值必须大于等于d。
     *
     * 请你计算，有多少个不同的等式满足这些限制。由于答案可能很大，请将答案mod(998244353)后输出。
     *
     *
     *
     * 输入描述
     * 输入包含三个数n,k,d（1≤d≤k≤n≤1000）
     *
     * 输出描述
     * 输出包含一行，即方案数。
     *
     * 样例输入
     * 5 3 2
     * 样例输出
     * 12
     *
     * 提示
     * 样例解释
     * 2+3=5
     * 3+2=5
     * 1+1+3=5
     * 1+3+1=5
     * 3+1+1=5
     * 1+2+2=5
     * 2+1+2=5
     * 2+2+1=5
     * 1+1+1+2=5
     * 1+1+2+1=5
     * 1+2+1+1=5
     * 2+1+1+1=5
     * 共12种填法
     */
    static long ans = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        int k = in.nextInt();
        int d = in.nextInt();
        Deque<Integer> path = new LinkedList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        dfs(path, 0, target, k, d, queue);

        System.out.println(ans % 998244353);
    }

    private static void dfs(Deque<Integer> path, int start, int target, int k, int d, PriorityQueue<Integer> queue) {
        if (target == 0){
            if (queue.peek() < d){
                return;
            }
            ans++;
        }

        for (int i = 1; i <= k; i++) {
            if (target < 0){
                break;
            }
            path.addLast(i);
            queue.add(i);
            dfs(path, 0, target - i, k, d, queue);
            queue.remove(i);
            path.removeLast();
        }
    }


}
