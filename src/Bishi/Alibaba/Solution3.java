package Bishi.Alibaba;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Solution3 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            HashMap<Character, Character> map = new HashMap<>();
            map.put('{','}');
            map.put('[',']');
            map.put('(',')');
            while (in.hasNextLine()){
                String s = in.nextLine();
                char[] chars = s.toCharArray();
                Stack<Character> stack = new Stack<>();
                stack.add('?');
                for (char aChar : chars) {
                    if (map.containsKey(aChar)) stack.add(aChar);
                    else if (map.get(stack.pop()) != aChar) {
                        System.out.println(false);
                        break;
                    }
                }
                if (stack.size() == 1) System.out.println(true);
            }


        }
}
