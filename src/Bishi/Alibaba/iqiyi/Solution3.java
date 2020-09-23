package Bishi.Alibaba.iqiyi;

import java.util.*;

public class Solution3 {

    static class Item{
        int a;
        int b;
        int c;

        public Item(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] s1 = s.split(" ");
        int[] nums = new int[s1.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(s1[i]);
        }
        Arrays.sort(nums);
        List<Item> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0){
                    res.add(new Item(nums[i], nums[L] ,nums[R]));
                    while (L < R && nums[L] == nums[L + 1]){
                        L = L + 1;
                    }
                    while (L < R && nums[R] == nums[R - 1]){
                        R = R - 1;
                    }
                    R = R - 1;
                    L = L + 1;
                } else if(sum > 0){
                    R = R - 1;
                } else {
                    L = L + 1;
                }
            }
        }

        for (Item item : res) {
            System.out.println(item.a + " " + item.b + " " + item.c);
        }


    }


}
