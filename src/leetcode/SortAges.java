package leetcode;

import utils.Utils;


public class SortAges {

    public static void sortAges(int[] arr){
        int length = arr.length;
        int oldestAge = 99;
        int[] timesOfAges = new int[oldestAge+1];
        for (int i = 0; i < length; i++) {
            timesOfAges[arr[i]]++;
        }
        int index = 0;
        for (int i = 0; i <= oldestAge; i++) {
            for (int j = 0; j < timesOfAges[i]; j++) {
                arr[index] = i;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*100);
        }
        sortAges(arr);
        Utils.printArray(arr);
    }
}
