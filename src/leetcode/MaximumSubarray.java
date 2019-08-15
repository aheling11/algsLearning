package leetcode;

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        return subProcess(nums, 0, n-1);
    }

    // 在线 时间复杂度为O(N)
    public static int subProcess(int[] nums) {
        int n = nums.length;
        int ThisSum = 0;
        int MaxSum = nums[0];
        for(int i = 0; i < n; i++) {
            ThisSum += nums[i];
            if (ThisSum > MaxSum) {
                MaxSum = ThisSum;
            }
            if (ThisSum < 0) {
                ThisSum = 0;
            }
        }
        return MaxSum;
    }


    // 分治思想的解法
    public static int subProcess(int[] nums, int l, int r) {

        if (l >= r) {
            return nums[l];
        }
        int mid = l + ((r - l) >> 1);
        int Lvalue = subProcess(nums, l, mid);
        int Rvalue = subProcess(nums, mid+1, r);

        int ThisSum = 0;
        int LMaxSum = nums[mid];
        for (int i = mid; i >= l; i--) {
            ThisSum += nums[i];
            if (ThisSum > LMaxSum) {
                LMaxSum = ThisSum;
            }
        }
        ThisSum = 0;
        int RMaxSum = nums[mid+1];
        for (int i = mid+1; i <= r; i++) {
            ThisSum += nums[i];
            if (ThisSum > RMaxSum) {
                RMaxSum = ThisSum;
            }
        }

        int MaxSum = LMaxSum + RMaxSum;
        if (Lvalue > MaxSum) {
            MaxSum = Lvalue;
        }
        if ( Rvalue > MaxSum ) {
            MaxSum = Rvalue;
        }
        return MaxSum;

    }


    public static void main(String args[]) {
        int[] arr = new int[]{-1,-2,-3,0};
        //本题两种解法
        System.out.println(maxSubArray(arr));
    }
}
