package leetcode;

import java.util.HashMap;
import java.util.HashSet;

class largestIsland {
    int cnt = 0;
    int k = 2;
    HashSet<Integer> set;
    public int largestIsland(int[][] grid) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                cnt = 0;
                bfs(grid, i, j, k);
                map.put(k++, cnt);
            }
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    set = new HashSet<>();
                    int t = fill(grid, i + 1, j, map, set) +
                            fill(grid, i - 1, j, map, set) +
                            fill(grid, i, j + 1, map, set) +
                            fill(grid, i, j - 1, map, set) + 1;
                    res = Math.max(res, t);
                }
            }
        }

        return res;
    }

    public void bfs(int[][] grid, int i, int j, int k){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        if(grid[i][j] == 1){
            grid[i][j] = k;
            cnt++;
        }
        bfs(grid, i + 1, j, k);
        bfs(grid, i - 1, j, k);
        bfs(grid, i, j + 1, k);
        bfs(grid, i, j - 1, k);
    }


    public int fill(int[][] grid, int i, int j, HashMap<Integer, Integer> map, HashSet<Integer> set){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || set.contains(grid[i][j])){
            return 0;
        }
        set.add(grid[i][j]);
        return map.get(grid[i][j]);
    }

    public static void main(String[] args) {

    }
}