package Test;

import java.util.Arrays;

public class Union_find {
    static int[] fa = new int[100];
    static int[] rank = new int[100];

    public int find(int x){
        if (fa[x] == x){
            return x;
        } else {
            fa[x] = find(fa[x]);
            return fa[x];
        }
    }

    public void merge(int i, int j){
        int x = find(i), y = find(j);
        if (rank[x] <= rank[y]) fa[x] = y;
        else fa[y] = x;
        if (rank[x] == rank[y] && x != y){
            rank[y]++;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
            rank[i] = 1;
        }



    }
}
