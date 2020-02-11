package leetcode;

public class MoreThanHalfNum_Solution {
    public static int MoreThanHalfNum_Solution(int [] array) {
        int L = 0;
        int R = array.length - 1;
        int midindex = array.length>>1;
        int index = partition(array, L, R);
        while (index != midindex){
            if (index < midindex){
                L = index + 1;
                index = partition(array, L, R);
            } else if (index > midindex){
                R = index - 1;
                index = partition(array, L, R);
            }
        }
        if (moretanhalf(array, array[index])){
            return array[index];
        } else {
            return 0;
        }
    }

    public static int MoreThanHalfNum_BoyerMoore(int [] array) {
       int times = 0;
       int number = array[0];
        for (int i = 0; i < array.length; i++) {
            if (times == 0){
                number = array[i];
                times = 1;
            } else if (number == array[i]){
                times++;
            } else if (number != array[i]){
                times--;
            }
        }
        if (moretanhalf(array, number)){
            return number;
        } else {
            return 0;
        }
    }

    public static boolean moretanhalf(int[] arr, int number){
        int halfn = arr.length>>1;
        int times = 0;
        for (int value : arr) {
            if (value == number) {
                times++;
            }
        }
        return times > halfn;
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
        return cur;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,2,4,2,5,2,3,2,3};
        // 3 2 2 2 2 1 6 6 8 9 4
        int a = MoreThanHalfNum_BoyerMoore(arr);
        System.out.println(a);
    }
}