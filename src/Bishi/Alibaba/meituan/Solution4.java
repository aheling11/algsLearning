package Bishi.Alibaba.meituan;

import java.util.*;

public class Solution4 {


    static long ans = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> s = new ArrayList<>();
        while (in.hasNextLine()){
            s.add(in.nextLine());
        }
        int max = 0;
        for (String s1 : s) {
            if (s1.length() > max){
                max = s1.length();
            }
        }
        System.out.println(max);
    }




}
