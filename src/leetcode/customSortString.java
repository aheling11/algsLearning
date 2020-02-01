package leetcode;

import java.util.Arrays;
import java.util.HashMap;

class customSortString {
    public static String customSortString(String S, String T) {
        if (S.length() < 1){
            return T;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }
        char[] chars = new char[S.length()];
        int[] numberOfchar = new int[S.length()];
        Arrays.fill(chars, ' ');

        StringBuilder t = new StringBuilder();
        for (int i = 0; i < T.length(); i++) {
            char tchar = T.charAt(i);
            if (map.containsKey(tchar)){
                chars[map.get(tchar)] = tchar;
                numberOfchar[map.get(tchar)] += 1;
            } else {
                t.append(tchar);
            }
        }

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' '){
                for (int j = 0; j < numberOfchar[i]; j++) {
                    s.append(chars[i]);
                }
            }
        }

        return s.toString() + t.toString();
    }

    public static String customSortString_2(String S, String T) {
        if (S.length() < 1){
            return T;
        }
        int[] count = new int[26];
        for(char c : T.toCharArray()){
            count[c - 'a'] += 1;
        }

        StringBuilder ans = new StringBuilder();
        for (char c : S.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; i++) {
                ans.append(c);
            }
            count[c - 'a'] = 0;
        }

        for(char c = 'a'; c < 'z'; c++){
            for (int i = 0; i < count[c - 'a']; i++) {
                ans.append(c);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String S = "kqep";
        String T = "pekeq";

        String s = customSortString(S, T);

        System.out.println(s);

    }
}