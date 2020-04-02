package ToOffer;

class maxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length < 1){
            return 0;
        }
        int sum = 0;
        int max = sum;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0){
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            if (sum > max){
                max = sum;
            }
        }
        return max;
    }
}