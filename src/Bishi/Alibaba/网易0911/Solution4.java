package Bishi.Alibaba.网易0911;


import java.util.HashSet;
import java.util.Scanner;

public class Solution4 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String boysString = in.nextLine();
        String girlsString = in.nextLine();
        String[] bs = boysString.split(" ");
        String[] gs = girlsString.split(" ");
        int[] Bids = new int[bs.length];
        for (int i = 0; i < bs.length; i++) {
            Bids[i] = Integer.parseInt(bs[i]);
        }
        int[] Gids = new int[gs.length];
        for (int i = 0; i < gs.length; i++) {
            Gids[i] = Integer.parseInt(gs[i]);
        }
        int n = in.nextInt();
        int[] attendB = new int[n];
        int[] attendG = new int[n];
        HashSet<Integer> bSet = new HashSet<>();
        HashSet<Integer> gSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            attendB[i] = in.nextInt();
            bSet.add(attendB[i]);
            attendG[i] = in.nextInt();
            gSet.add(attendG[i]);
        }

        System.out.println(bSet.size());


    }




}
