package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class orangesRotting {

    public static int orangesRotting(int[][] grid) {
        int[] rrow = {0,0,1,-1};
        int[] ccol = {1,-1,0,0};
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1){
                    count++;
                } else if (grid[i][j] == 2){
                    queue.add(col * i + j);
                }
            }
        }
        if (count == 0) return 0;
        int depth = -1;
        while (!queue.isEmpty()){
            int n = queue.size();
            while (n > 0){
                int cur = queue.poll();
                int r = cur / col;
                int c = cur % col;
                for (int k = 0; k < 4; k++) {
                    int tr = r + rrow[k];
                    int tc = c + ccol[k];
                    if (tr < row && tr >= 0 && tc < col && tc >= 0 && grid[tr][tc] == 1){
                        grid[tr][tc] = 2;
                        count--;
                        queue.add(tr * col + tc);
                    }
                }
                n--;
            }
            depth++;
        }
        if (count > 0) depth = -1;
//        System.out.println(count);
        return depth;
    }

    public static void main(String[] args) {
//        int[][] arr = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
//        int[][] arr = new int[][]{{2,1,1},{0,1,1},{1,0,1}};
        int[][] arr = new int[][]{{0}};
        int i = orangesRotting(arr);
        System.out.println(i);
    }
}