package Bishi.Alibaba.iqiyi;

import java.util.HashMap;
import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])){
                left = Math.max(left, map.get(chars[i]) + 1);
            }
            max = Math.max(max, i - left + 1);
            map.put(chars[i], i);
        }
    }
}
