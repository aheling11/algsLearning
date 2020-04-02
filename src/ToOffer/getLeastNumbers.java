package ToOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class getLeastNumbers {
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || k == 0) return new int[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int i = 0; i < arr.length; i++) {
            if (queue.size() < k){
                queue.add(arr[i]);
            } else if (arr[i] < queue.peek()){
                queue.poll();
                queue.add(arr[i]);
            }
        }
        int[] ans = new int[k];
        int i = 0;
        while (!queue.isEmpty()){
            System.out.println(queue.peek());
            ans[i++] = queue.poll();
        }
        return ans;
    }

    public static int[] getLeastNumbers_2(int[] arr, int k) {
        if (arr == null || k == 0) return new int[0];
        int L = 0;
        int R = arr.length - 1;
        int cur = partition(arr,L, R)[0];
        while (cur != k){
            //cur在k的右边,往左边找
            if (cur > k){
                R = cur - 1;
                cur = partition(arr, L, R)[0];
            } else {
                L = cur + 1;
                cur = partition(arr, L,  R)[0];
            }
        }
        return Arrays.copyOfRange(arr, 0, k);
    }
    public static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        int cur = l;
        while ( cur < more) {
            if (arr[cur] < arr[r]) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] > arr[r]) {
                swap(arr, --more, cur);
            } else {
                cur++;
            }
        }
        swap(arr, more, r);
        return new int[]{ less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,4};
        int[] leastNumbers_2 = getLeastNumbers_2(arr, 2);

    }
}