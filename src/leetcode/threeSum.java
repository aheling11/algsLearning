package leetcode;


import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static utils.Utils.*;


/**
 * leetcode15 three sum
 *
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]

 */
public class threeSum {

    public static void solution(){
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-1,-1,0,1};
        List<List<Integer>> lists = threeSum(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
//        System.out.println(lists.size());


    }

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k-1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0){
                    while ( i < j && nums[i] == nums[++i]);
                } else if (sum > 0){
                    while ( i < j && nums[j] == nums[--j]);
                } else {
                    lists.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while ( i < j && nums[i] == nums[++i]);
                    while ( i < j && nums[j] == nums[--j]);
                }
            }
        }
        return lists;
    }



    public static void test() {
        int[] nums = {-4,-1,-1,-1,0,2};
        int i = 1;
        while (i < nums.length && nums[i] == nums[++i]);
        System.out.println(i);
    }
    public static void main(String[] args) {
//        test();
//        int maxruntime = 5000;
//        int size = 10;
//        int value = 10;
//        for (int i = 0; i < maxruntime; i++) {
//
//            }
//        }

        solution();
    }

}
