package Niuke;

public class InversionNum {

    public static int InverseNum(int arr[]) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return sortProcess(arr, 0, arr.length - 1);
    }

    public static int sortProcess(int arr[], int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return sortProcess(arr, L, mid)+
            sortProcess(arr, mid+1, R)+
            merge(arr, L, mid, R);
    }

    public static int merge(int arr[], int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2= mid + 1;
        int result = 0;
        while(p1 <= mid && p2 <= R) {
            result += arr[p1] < arr[p2] ? arr[p1] * (R-p2+1) : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return result;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,5,2,3,6,1};
        System.out.println(InverseNum(arr));
    }

}
