package leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

class checkInclusion {
    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for(char ch : s1.toCharArray()){
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        
        while(right < s2.length()){
            char t = s2.charAt(right);
            right++;
            if(need.containsKey(t)){
                window.put(t, window.getOrDefault(t, 0) + 1);
                if(window.get(t).equals(need.get(t))){
                    valid++;
                }
            }
            while(right - left >= s1.length()){
                if(valid == need.size()) return true;
                char ch = s2.charAt(left);
                left++;
                if(need.containsKey(ch)){
                    if(window.get(ch).equals(need.get(ch))){
                        valid--;
                    }
                    window.put(ch, window.getOrDefault(ch, 0) - 1);
                }
            }
        }
        return false;
    }
}