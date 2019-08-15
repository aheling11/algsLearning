package Niuke;

public class Quicksort {

    public static void quicksort(int[] arr) {
        quicksortprocess(arr, 0, arr.length - 1);
    }

    public static void quicksortprocess(int[] arr, int L, int R) {
        if (L < R) {
            int[] p = partition(arr, L, R);
            quicksortprocess(arr, L, p[0] - 1);
            quicksortprocess(arr, p[1]+1, R);
        }

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
        int arr[] = new int[]{1,5,3,6};
        quicksort(arr);
        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
