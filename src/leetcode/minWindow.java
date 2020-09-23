package leetcode;

import java.util.HashMap;

class minWindow {
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for(Character ch : t.toCharArray()){
            need.put(ch, need.getOrDefault(ch,0) + 1);
        }
        char[] chars = s.toCharArray();
        int left = 0, right = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while(right < s.length()){
            char c = chars[right];
            right++;
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            while(valid == need.size()){
                if(right - left < len){
                    len = right - left;
                    start = left;
                }
                char d = chars[left];
                left++;
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        String s = "aa";
        String t = "aa";
        minWindow(s,t);
    }
}