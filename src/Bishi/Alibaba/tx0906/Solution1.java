package Bishi.Alibaba.tx0906;

import java.util.Scanner;

public class Solution1 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = in.nextInt();
        }
        int p1 = 0;
        int p2 = 0;
        while(p1 < n && p2 < m){
            if(arr1[p1] > arr2[p2]){
                p1++;
            } else if(arr1[p1] < arr2[p2]){
                p2++;
            } else {
                System.out.print(arr1[p1] + " ");
                p1++;
            }
        }

    }
}
