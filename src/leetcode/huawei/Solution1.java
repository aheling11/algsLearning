package leetcode.huawei;

import java.util.LinkedList;
import java.util.Queue;

class Solution1 {
    public static int[] findDiagonalOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] res = new int[n * m];
        int r = 0, c = 0;
        for(int i = 0; i < res.length; i++){
            res[i] = matrix[r][c];
            if((r + c) % 2 == 0){
                if(c == m - 1){
                    r++;
                } else if(r == 0){
                    c++;
                } else {
                    r--;
                    c++;
                }
            } else {
                if (r == n - 1){
                    c++;
                } else if (c == 0){
                    r++;
                } else {
                    r++;
                    c--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[] res = findDiagonalOrder(nums);
        for (int re : res) {
            System.out.println(re);
        }
    }

}