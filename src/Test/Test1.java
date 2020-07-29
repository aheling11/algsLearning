package Test;


import utils.Utils;

import java.util.*;

import static Niuke.MergesortTEST.generateRandomArray;
import static utils.Utils.*;


public class Test1 {

    public static void mergesort(int[] arr, int L, int R){
        if (L >= R){
            return;
        }
        int mid = L + ((R - L) >> 1);
        mergesort(arr, L, mid);
        mergesort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R){
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int p = 0;
        while(p1 <= mid && p2 <= R){
            help[p++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid){
            help[p++] = arr[p1++];
        }
        while (p2 <= R){
            help[p++] = arr[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    // for test
    public static void rightmethod(int[] arr) {
        Arrays.sort(arr);
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
            mergesort(arr1, 0, arr1.length - 1);
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
