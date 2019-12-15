package Test;

import java.util.Arrays;

import static utils.Utils.*;

public class Test {

    public static void Bubblesort(int[] arr) {
        for (int i = arr.length - 1; i >= 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]){
                    swap(arr, j , j+ 1);
                }
            }
        }
    }

    public static void selectsort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            int minindex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minindex = arr[j] < arr[minindex] ? j : minindex;
            }
            swap(arr, i, minindex);
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
        swap(arr, L+ (int) (Math.random() * (R - L + 1)), R);
        int cur = L;
        int less = L - 1;
        int more = R;
        while( cur < more) {
            if (arr[cur] < arr[R]) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] > arr[R]){
                swap(arr, --more, cur);
            } else {
                cur++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }


    public static void heapsort(int[] arr, int L, int R){
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapinsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0){
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    /**
     * 上浮
     * @param arr
     * @param index
     */
    public static void heapinsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]){
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr,int index,  int size) {
        int left = index * 2 + 1;
        while (left < size){
           int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
//           int largest = left + 1 < size && arr[left] > arr[left + 1] ? left : left + 1;
           largest = arr[largest] > arr[index] ? largest : index;
           if (largest == index) {
               break;
           }
           swap(arr, index, largest);
           index = largest;
           left = index * 2 + 1;
       }

    }


    public static void bucketsort(int[] arr, int L, int R){
        int[] carr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            carr[arr[i]]++;
        }
        printArray(carr);
        int k = 0;
        for (int i = 0; i < carr.length; i++) {
            for (int j = 0; j < carr[i]; j++) {
                System.out.print(i + " " );
            }
        }
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{-4,3,-1,0,-1,1,0,0};
        int size = 100;
        int value = 100;

//        for (int i = 0; i < 5000; i++) {
//            int[] arr = generateRandomArray(size, value);
//            int[] arr1 = copyArray(arr);
//            heapsort(arr,0, arr.length - 1);
//            Arrays.sort(arr1);
//            if (!isEqual(arr, arr1)) {
//                System.out.println("fuck");
//            }
//        }
//        System.out.println("nice");


        int[] arr = new int[]{2,7,5,2};
        bucketsort(arr,0, arr.length - 1);
        printArray(arr);
    }
}
