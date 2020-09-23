package Bishi.Alibaba.网易0911;


import java.util.Scanner;

public class Solution3 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] S = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            S[i] = in.nextInt();
        }
        System.out.println(S.length - 1);

    }




}
