package leetcode;


/**
 *
 * 26. Remove Duplicates from Sorted Array
 */
class RemoveDuplicatesfromSortedArray {
    public static int solution1() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        return removeDuplicatesfromSortedArray(nums);
    }
    public static int removeDuplicatesfromSortedArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[i+1] = nums[j];
                i++;
            }
        }
        return i + 1;

    }




    public static void main(String[] args) {
        solution1();
    }
}