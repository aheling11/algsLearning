package ToOffer;

import java.util.*;

class permutation {
    public static String[] permutation(String s) {
        if (s == null || s.equals("")) return null;
        char[] chars = s.toCharArray();
        Set<String> ans = new HashSet<>();
//        List<String> ans = new LinkedList<>();
        process(chars, ans, 0);
        String[] res = new String[ans.size()];
        int idx = 0;
        for(String str : ans){
            System.out.println(str);
            res[idx++] = str;
        }
        return res;
    }

    public static void process(char[] chars,Set<String> set, int start){
        if (start == chars.length - 1){
            StringBuilder sb = new StringBuilder();
            for (char c: chars) {
                sb.append(c);
            }
            set.add(sb.toString());
        }
        for (int i = start; i < chars.length; i++) {
            swap(chars, i, start);
            process(chars,  set, start + 1);
            swap(chars, i, start);
        }
    }

    public static void swap(char[] chars, int i, int j){
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

    public static void main(String[] args) {
        permutation("abcd");
    }
}