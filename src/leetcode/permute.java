package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class permute {
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        Deque<Integer> path = new LinkedList<>();
        // for(int i = 0; i < nums.length; i++){
            dfs(nums, path, 0);
        // }
        return res;
    }

    public static void dfs(int[] nums, Deque<Integer> path, int start){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < nums.length; i++){
            path.addLast(nums[i]);
            dfs(nums, path, i);
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        permute(nums);
    }
}