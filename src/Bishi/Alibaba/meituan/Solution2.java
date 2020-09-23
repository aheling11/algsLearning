package Bishi.Alibaba.meituan;

import java.util.Scanner;

public class Solution2 {
    /**
     * 小团的装饰物2
     * 时间限制： 3000MS
     * 内存限制： 589824KB
     * 题目描述：
     * 小团需要购买m样装饰物。商店出售n种装饰物，按照从小到大的顺序从左到右摆了一排。对于每一个装饰物，小团都给予了一个美丽值ai。
     *
     * 小团希望购买的装饰物有着相似的大小，所以他要求购买的装饰物在商店中摆放的位置是连续的一段。小团还认为，一个装饰物的美丽值不能低于k，否则会不好看。
     *
     * 现在，请你计算小团有多少种不同的购买方案。
     *
     *
     *
     * 输入描述
     * 输入第一行包含三个数n,m,k
     *
     * 接下来一行n个整数ai ( 1≤ i ≤n )，空格隔开，表示商店从左到右摆放的每个装饰物的美丽值。
     *
     * n , m≤100000
     *
     * 1≤ai ,k≤10^9
     *
     * 输出描述
     * 输出一个数，表示小团购买的方案数。
     *
     *
     * 样例输入
     * 8 2 5
     * 5 5 5 4 5 5 5 5
     * 样例输出
     * 5
     *
     * 提示
     * 有[1,2][2,3][5,6][6,7][7,8] 共5段
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        int[] pre = new int[100001];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            pre[i + 1] = pre[i] + (nums[i] >= k ? 1 : 0);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (pre[i + m] - pre[i] >= m){
                res++;
            }
        }

        System.out.println(res);
//        for (int i = 0; i < nums.length; i++) {
//            System.out.print(nums[i] + " ");
//        }
//        System.out.println();
//        for (int i = 0; i < n + 1; i++) {
//            System.out.print(pre[i] + " ");
//        }

//        System.out.println(nums.length - 1);


    }


}
