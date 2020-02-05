package Test;


import utils.Utils;

import java.util.Arrays;
import java.util.Comparator;

import static utils.Utils.*;


public class Test1 {

    class Mycomparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 < o2){
                return 1;
            } else if (o1 > o2){
                return -1;
            } else{
                return 0;
            }
        }
    }

    public static int findKnumber(int[] nums, int k){
        int R = nums.length - 1;
        int L = 0;
        int index = partition(nums, 0, R);
        int length = nums.length - index;
        while(length != k){
            // 如果index右边的数小于k，则在index左边继续找
            if (length < k){
                R = index - 1;
                index = partition(nums, L, R); //每次更新
            }
            // 如果index右边的数大于k，则在index右边继续找
            else{
                L = index + 1;
                index = partition(nums, L, R);
            }
            length = nums.length - index;
        }
        return nums[index];
    }

    //就是快排里的partition操作
    public static int partition(int[] arr, int L, int R){
        swap(arr, R, L + (int)(Math.random()*(R - L + 1)));
        int less = L - 1;
        int more = R;
        int cur = L;
        while(cur < more){
            if (arr[cur] < arr[R]){
                swap(arr, cur++, ++less);
            } else if(arr[cur] > arr[R]){
                swap(arr, cur, --more);
            } else {
                cur++;
            }
        }
        swap(arr, cur, R);
        return more;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int rightMethod(int[] arr, int k){
        Arrays.sort(arr);
        return arr[arr.length - k];
    }


    public static void main(String[] args) throws Exception {

        int size = 100;
        int value = 100;
        for (int i = 0; i < 50; i++) {
            int[] arr = GenerateRandomArray(size, value);

            int a = findKnumber(arr, 2);
            int b = rightMethod(arr, 2);
            if (a != b){
                System.out.println("fuck!");
            }
        }
        System.out.println("nice");


    }



}
