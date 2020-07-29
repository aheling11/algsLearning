package leetcode;

class minSubArrayLen {
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums.length < 1){
            return 0;
        }
        int minlength = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while(left < nums.length && right < nums.length){
            sum += nums[right];
            while (sum >= s){
                minlength = Math.min(minlength, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right ++;
            
        }
        return minlength == Integer.MAX_VALUE ? 0 : minlength;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, arr));
    }
}