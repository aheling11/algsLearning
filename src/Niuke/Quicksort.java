package Niuke;

public class Quicksort {

    public static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
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
