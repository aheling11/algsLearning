package leetcode;


import java.util.HashMap;

import static utils.Utils.*;


/**
 * leetcode1 two sum
 * hash map
 */
public class twoSum {

    public static void solution(){
        int[] nums = {-1,-2,-3,-4,-5};
        printArray(twosum(nums, -8));
    }

    public static int[] twosum(int[] nums, int target){
        int[] arr = new int[2];
        for(int i = 0; i < nums.length; i++){
            int p1 = nums[i];
            for(int j = i + 1; j< nums.length; j++){
                int p2 = nums[j];
                if(p1 + p2 == target) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return null;
    }
    public static int[] twosum_hash(int[] nums, int target){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (hashMap.containsKey(temp) && hashMap.get(temp) != i) {
                return new int[]{i, hashMap.get(temp)};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int maxruntime = 5000;
        int size = 10;
        int value = 10;
        for (int i = 0; i < maxruntime; i++) {
            int[] randomarray = generateRandomArray(size, value);
            int randomtarget = (int) (Math.random()+1)*size;
            int[] arr1 = twosum(randomarray, randomtarget);
            int[] arr2 = twosum_hash(randomarray, randomtarget);
            if (!isEqual(arr1, arr2)){
                printArray(randomarray);
                System.out.println(randomtarget);
                printArray(arr1);
                printArray(arr2);
                System.out.println("fuck!");
                break;
            }
        }
    }

}
