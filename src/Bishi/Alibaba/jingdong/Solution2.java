package Bishi.Alibaba.jingdong;

import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0){
            int n = in.nextInt();
            int m = in.nextInt();
            char[][] grid = new char[n][m];
            in.nextLine();
            int startI = 0;
            int startJ = 0;
            for (int i = 0; i < n; i++) {
                String s = in.nextLine();
                char[] chars = s.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    if (chars[j] == 'S'){
                        startI = i;
                        startJ = j;
                        grid[i][j] = 'S';
                    } else
                    if (chars[j] == 'E'){
                        grid[i][j] = 'E';
                    } else if (chars[j] == '#'){
                        grid[i][j] = '#';
                    } else grid[i][j] = '.';
                }
            }

            boolean res = dfs(grid, startI, startJ);
            if (res) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static boolean dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j >= grid[0].length || j < 0 || grid[i][j] == '#'){
            return false;
        }
        if (grid[i][j] == 'E'){
            return true;
        }
        grid[i][j] = '#';
        Boolean res =
                dfs(grid, i + 1, j) ||
                dfs(grid, i - 1, j) ||
                dfs(grid, i , j + 1) ||
                dfs(grid, i, j - 1);
        grid[i][j] = '.';
        return res;
    }



}
