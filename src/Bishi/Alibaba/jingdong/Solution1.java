package Bishi.Alibaba.jingdong;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        String pattern = "([0-9]{4}D)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(s);
        while (m.find()){
            String numString = m.group();
            int num = Integer.parseInt(numString);
            if (num <= 3999 && num >= 1000){
                System.out.print(num + " ");
            }
        }
    }
}
