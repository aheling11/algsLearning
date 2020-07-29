package ToOffer;

import java.util.HashMap;
import java.util.Stack;

class isValid {
    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>(){{
            put('[',']');put('{','}');put('(',')');put('?','?');
        }};
        Stack<Character> stack = new Stack<Character>(){{push('?');}};
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        for(char c : s.toCharArray()){
            if(map.containsKey(c)){
                stack.push(c);
            } else if(map.get(stack.pop()) != c){
                return false;
            }
        }
        return stack.size() == 1;
    }

    public static void main(String[] args) {
        String s = "(";
        System.out.println(isValid(s));
    }
}