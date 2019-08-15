package Niuke;

public class BubbleSort {

    public static void Bubblesort(int[] arr, int l, int r) {

        for(int e = arr.length - 1; e > 0; e--) {
            for(int i = 0; i < e; i++) {
                if (arr[i] > arr[e]) {
                    swap(arr, e, i);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

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
        int[] arr = new int[]{2,5,1,6,8,3};
        Bubblesort(arr, 0, arr.length-1);
        printArray(arr);
    }
}
