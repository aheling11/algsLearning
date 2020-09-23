package Bishi.Alibaba;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        char[] chars = s.toCharArray();
        int cnt = 1;
        boolean isOdd = (k & 1) == 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (k > chars.length) break;
            if (cnt >= k){
                if(isOdd){
                    if (chars[i] == '0') sb.append('1');
                    if (chars[i] == '1') sb.append('0');
                } else {
                    sb.append(chars[i]);
                }
            }
            if (i > 0 && chars[i] != chars[i - 1]){
                cnt++;
            }
        }
        if (sb.length() < 1) System.out.println('0');
        else {
            String s1 = sb.toString();
            boolean flag = false;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == '1') {
                    String res = s1.substring(i);
                    System.out.println(res);
                    break;
                }
                if (i == s1.length() - 1){
                    flag = true;
                }
            }
            if (flag){
                System.out.println('0');
            }

        }

    }
}
