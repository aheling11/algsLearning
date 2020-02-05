package Test;

import java.util.Arrays;

import static Niuke.MergesortTEST.generateRandomArray;

public class tiaohzhan {

    public static void bubblesort(int[] arr){
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]){
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void selectsort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minindex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minindex]){
                    minindex = j;
                }
            }
            swap(arr, i, minindex);
        }
    }

    public static void insertsort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]){
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    public static void mergesort(int[] arr, int L, int R){
        if (L >= R){
            return;
        }
        int mid = L + ((R - L)>>1);
        mergesort(arr, L, mid);
        mergesort(arr, mid + 1, R);
        merge(arr, L, R, mid);
    }

    public static void merge(int[] arr, int L, int R, int mid){
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int p = 0;
        while(p1 <= mid && p2 <= R){
            help[p++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid){
            help[p++] = arr[p1++];
        }
        while(p2 <= R){
            help[p++] = arr[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[L+i] = help[i];
        }
    }

    public static void quicksort(int[] arr, int L, int R){
        if (L < R){
            int[] p = partition(arr, L, R);
            quicksort(arr, L, p[0] - 1);
            quicksort(arr, p[1] + 1, R);
        }
    }

    public static int[] partition(int[] arr, int L, int R){
        swap(arr, L + (int)(Math.random()*(R - L + 1)), R);
        int less = L - 1;
        int cur = L;
        int more = R;
        while(cur < more){
            if (arr[cur] > arr[R]){
                swap(arr, cur, --more);
            } else if(arr[cur] < arr[R]){
                swap(arr, cur++, ++less);
            } else {
                cur++;
            }
        }
        swap(arr, cur, R);
        return new int[]{less + 1, more};
    }

    public static void heapsort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            heapinsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while(size > 0){
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    public static void heapinsert(int[] arr, int index){
        while(arr[index] > arr[(index - 1) / 2]){
            swap(arr, index, (index - 1) / 2 );
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int size){
        int left = (index * 2) + 1;
        while(left < size){
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (index == largest) break;
            swap(arr, index, largest);
            index = largest;
            left = (index * 2) + 1;
        }
    }

    public static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    // for test
    public static void rightmethod(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] GenerateRandomArray(int maxSize, int maxValue) {
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

    // for test
    public static void main(String[] args) {
        int testTime = 10;
        int maxSize = 1000;
        int maxValue = 1000;
        boolean succeed = true;
        long start = System.currentTimeMillis();
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            heapsort(arr1);
            rightmethod(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }

        long end = System.currentTimeMillis();
        System.out.println((end - start)/1000 + " ms");
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");


    }


}
