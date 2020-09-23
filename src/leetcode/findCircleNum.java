package leetcode;

import java.util.Arrays;
import java.util.HashSet;

class findCircleNum {
    static int[] fa;
    static int[] rank;
    public static int findCircleNum(int[][] M) {
        fa = new int[M.length];
        rank = new int[M.length];
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }
        Arrays.fill(rank, 1);
        for(int i = 0; i < M.length; i++){
            for(int j = i + 1; j < M[0].length; j++){
                if(M[i][j] == 1){
                    merge(i, j);
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < fa.length; i++){
            set.add(find(fa[i]));
        }
        return set.size();
    }

    public static int find(int x){
        if(fa[x] == x) return x;
        else {
            fa[x] = find(fa[x]);
            return fa[x];
        }
    }

    public static void merge(int i, int j){
        int x = find(i),
                y = find(j);
        if(rank[x] <= rank[y]){
            fa[x] = y;
        } else fa[y] = x;
        if(rank[x] == rank[y] && x != y){
            rank[y] ++;
        }
    }

    public static void main(String[] args) {
        int[][] M = new int[][]{
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}
        };

        System.out.println(findCircleNum(M));
    }

}