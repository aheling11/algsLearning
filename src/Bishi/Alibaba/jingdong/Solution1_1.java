package Bishi.Alibaba.jingdong;

import java.util.Scanner;

public class Solution1_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9'){
                sb.append(chars[i]);
            } else {
                if (sb.length() == 4){
                    String s1 = sb.toString();
                    char[] chars1 = s1.toCharArray();
                    int point = 0;
                    for (int j = 0; j < chars1.length; j++) {
                        if (chars1[j] != '0'){
                            point = j;
                            break;
                        }
                    }
                    String substring = s1.substring(point);
                    int num = Integer.parseInt(substring);
                    if (num <= 3999 && num >= 1000){
                        System.out.print(num + " ");
                    }
                }
                sb = new StringBuilder();
            }
        }


    }
}
//2019 1000 3999 432543 32132189 3999 1000 00010 100 001 321jijoqw njkd 1 -123 3243243242342433999 3999