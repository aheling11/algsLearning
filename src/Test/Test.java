package Test;

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


    public static void insertsort(int[] arr){

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j+1, j);
                } else {
                    break;
                }
            }
        }
    }

    public static int getMax(int[] arr, int l, int r){
        if (l == r) {
            return arr[l];
        }
        int mid = (l + r)/2;
        int Lmax = getMax(arr, l, mid);
        int Rmax = getMax(arr, mid + 1, r);
        return Math.max(Lmax, Rmax);
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
        System.out.println(getMax(arr, 0, arr.length-1));
//        printArray(arr);
    }
}
