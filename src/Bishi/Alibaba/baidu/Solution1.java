package Bishi.Alibaba.baidu;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int n;
        int m;
        for (int i = 0; i < T; i++) {
            n = in.nextInt();
            m = in.nextInt();
            int[] nums = new int[n];
            int[] scores = new int[m];
            for (int j = 0; j < n; j++) {
                nums[j] = in.nextInt();
            }
            for (int j = 0; j < m; j++) {
                scores[j] = in.nextInt();
            }
            Arrays.sort(nums);
            Arrays.sort(scores);
            int[] res = new int[n];
            for (int j = 0; j < n; j++) {
                int cnt = find(scores, nums[j]);
                res[j] = cnt;
                if (res[j] == 0) break;
            }
            for (int j = 0; j < n; j++) {
                System.out.print(res[j] + " ");
            }
        }


    }

    public static int find(int[] scores, int target){
        int L = 0;
        int R = scores.length - 1;
        while (L <= R){
            int mid = L + (R - L) / 2;
            if (scores[mid] < target){
                L = mid + 1;
            } else if (scores[mid] > target){
                R = mid - 1;
            } else {
                R = mid - 1;
            }
        }
        return scores.length  - L;
    }
}
