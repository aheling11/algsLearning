package Niuke;

import utils.Utils;

public class Test_quicksort {

   public static void quicksort(int[] nums, int L, int R){
     if(L < R){
         int[] p = partition(nums, L, R);
         quicksort(nums, L, p[0] - 1);
         quicksort(nums, p[1] + 1, R);
     }
   }
    public static int[] partition(int[] nums, int L, int R){
        swap(nums, R, L + (int)(Math.random()*(R - L + 1)));
        int less = L - 1;
        int more = R;
        int cur = L;
        while(cur < more){
            if(nums[cur] < nums[R]){
                swap(nums, ++less, cur++);
            } else if(nums[cur] > nums[R]){
                swap(nums, --more, cur);
            } else {
                cur++;
            }
        }
        swap(nums, cur, R);
        return new int[]{less, more + 1};
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] =  temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,1,3,7,3,5};
        quicksort(nums, 0,  nums.length - 1);
        Utils.printArray(nums);
    }
}
