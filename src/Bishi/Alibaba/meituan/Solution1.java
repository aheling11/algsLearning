package Bishi.Alibaba.meituan;

import java.util.*;

/**
 * 照镜子
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小团有一个n×m的矩阵A， 他知道这是小美用一种特殊的方法生成的，具体规则如下:
 *
 * 小美首先写下一个n'×m的矩阵，然后小美每一次将这个矩阵上下翻转后接到原矩阵的下方。小美重复这个过程若干次（甚至可能是0次，也就是没有进行过这一操作），然后将操作后的矩阵交给小团。
 *
 * 小团想知道，小美一开始写下的矩阵是什么。因为小美可能有多种一开始的矩阵，小团想得到最小的矩阵（这里的最小指矩阵即n'×m的面积最小）。
 *
 *
 *
 * 输入描述
 * 输入包含两个整数n,m，表示小团矩阵的大小。
 *
 * 接下来n行，每行m个正整数，第 i 行第 j 列表示矩阵第 i 行第 j 列的数。
 *
 * 1≤n≤100000,1≤m≤5,矩阵内的数小于等于10
 *
 * 输出描述
 * 输出包含一个矩阵，一共n'行m列，表示小美一开始最小的矩阵。
 *
 *
 * 样例输入
 * 8 3
 * 1 0 1
 * 0 1 0
 * 0 1 0
 * 1 0 1
 * 1 0 1
 * 0 1 0
 * 0 1 0
 * 1 0 1
 * 样例输出
 * 1 0 1
 * 0 1 0
 *
 * 提示
 * 样例解释
 * 小美一开始的矩阵可能有以下3种：
 * 1.
 * 1 0 1
 * 0 1 0
 *
 * 2.
 * 1 0 1
 * 0 1 0
 * 0 1 0
 * 1 0 1
 *
 * 3.
 * 1 0 1
 * 0 1 0
 * 0 1 0
 * 1 0 1
 * 1 0 1
 * 0 1 0
 * 0 1 0
 * 1 0 1
 * 其中最小的矩阵为第一种。
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        int start = 0;
        int end = n - 1;
        if ((n&1)==1) {
            printGrid(0, n, m, grid);
        } else {
            while (isSym(grid, start, end, m)){
                end /= 2;
            }
            printGrid(start, end, m, grid);
        }

    }

    private static boolean isSym(int[][] grid, int start, int end, int m) {
        while (start < end){
            for (int i = 0; i < m; i++) {
                if (grid[start][i] != grid[end][i]) return false;
            }
            start++;
            end--;
        }
        return start != end;
    }


    public static void printGrid(int start, int end, int m, int[][] grid){
        for (int i = start; i <= end; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
