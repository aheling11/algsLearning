package Niuke;

public class selectsort {


    public static void selectsort(int[] arr, int l, int r) {

       for (int i = 0; i < arr.length; i++) {
           int minindex = i;
           for (int j = i + 1; j < arr.length; j++) {
               minindex = arr[j] < arr[minindex] ? j : minindex;
           }
           swap(arr, minindex, i);
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
        selectsort(arr, 0, arr.length-1);
        printArray(arr);
    }
}
