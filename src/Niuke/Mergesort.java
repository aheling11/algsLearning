package Niuke;// "static void main" must be defined in a public class.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class    Mergesort {

    public static void mergesort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    public static void sortProcess(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1); //防止越界
        sortProcess(arr, L, mid);
        sortProcess(arr,mid+1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R){
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while(p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while(p2 <= R) {
            help[i++] = arr[p2++];
        }
        for(int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }

    }

    public static void main(String[] args) {
       int arr[] = new int[]{2,5,1,2,3,4};
       mergesort(arr);
       for(int i = 0; i < arr.length; i++) {
           System.out.println(arr[i]);
       }
    }
}

