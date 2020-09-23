package Bishi.Alibaba.iqiyi;

import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] s1 = s.split(" ");
        int[] nums = new int[s1.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(s1[i]);
        }

        int cnt = 0;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]){
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0){
                res = nums[i];
            }
        }

        System.out.println(res);

    }
}
