package leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.concurrent.DelayQueue;

class canJump {
    /**
     * [2,3,1,1,4] True
     * [3,2,1,0,4] False
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) return false;
            k = Math.max(k, i + nums[i]);
        }
        return true;

    }

}