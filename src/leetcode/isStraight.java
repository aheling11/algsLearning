package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class isStraight {
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = 14;
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            if (nums[i] < min) min = nums[i];
            if (nums[i] > max) max = nums[i];
            if (set.contains(nums[i])) return false;
            set.add(nums[i]);
        }
        return max - min < 5;
    }
}