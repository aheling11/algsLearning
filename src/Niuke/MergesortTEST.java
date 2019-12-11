package Niuke;// "static void main" must be defined in a public class.


import java.util.Arrays;

public class MergesortTEST {

    public static void mergesort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortprocess(arr, 0, arr.length-1);
    }

    public static void sortprocess(int[] arr, int L, int R){
        if (L == R) {
            return;
        }
        int mid = (L + R)/2;
        sortprocess(arr, L, mid);
        sortprocess(arr, mid + 1, R);
        merge(arr, L, R, mid);
    }

    public static void merge(int[] arr, int L, int R, int mid){
        int[] help = new int[R - L + 1];
        int p = 0;
        int p1 = L;
        int p2 = mid + 1;
        while ( p1 <= mid && p2 <= R){
            help[p++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid){
            help[p++] = arr[p1++];
        }
        while (p2 <= R){
            help[p++] = arr[p2++];
        }

        int j = 0;
        for(int i = L; i <= R; i++) {
            arr[i] = help[j++];
        }
    }
    public static void rightmethod(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Math.random -> double [0,1)
        // (int)((maxSize + 1) * Math.random()) -> [0,size]的整数
        // size = 6, size + 1 = 7
        // Math.random() -> [0,1) * 7 -> [0,7)
        // double -> int[0,6] -> int
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergesort(arr1);
            rightmethod(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}

