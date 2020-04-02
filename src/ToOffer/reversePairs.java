package ToOffer;

import java.util.LinkedList;

class reversePairs {
    static int[] help;
    public static int reversePairs(int[] nums) {
        int ans = 0;
        help = new int[nums.length];
        ans += process(nums, 0, nums.length - 1);
        return ans;

    }

    public static int process(int[] nums, int L, int R){
        if (L >= R){
            return 0;
        }
        int res = 0;
        int mid = (R + L) >> 1;
        res += process(nums, L, mid);
        res += process(nums, mid + 1, R);
        res += merge(nums, L, R, mid);
        return res;
    }

    public static int merge(int[] nums, int L, int R, int mid){
        int p1 = mid;
        int p2 = R;
        int p = R - L;
        int res = 0;
        while (p1 >= L && p2 > mid){
            if (nums[p1] > nums[p2]){
                res += p2 - mid;
                help[p--] = nums[p1--];
            } else if (nums[p1] <= nums[p2]){
                help[p--] = nums[p2--];
            }
        }
        while (p1 >= L){
            help[p--] = nums[p1--];
        }
        while (p2 > mid){
            help[p--] = nums[p2--];
        }
        for (int i = 0; i < R - L + 1; i++) {
            nums[L + i] = help[i];
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{7,5,6,4};
        int[] nums = new int[]{5,4,3,2,1};
        int a = reversePairs(nums);
        System.out.println(a);
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for(Integer i : list){
            System.out.println(i);
        }
    }
}