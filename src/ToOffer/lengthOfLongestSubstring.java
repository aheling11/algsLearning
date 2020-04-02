package ToOffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() < 1) return 0;
        int start = 0;
        int end = 0;
        int max = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                start = Math.max(map.get(s.charAt(i)) + 1, start);
            }
            end = i;
            map.put(s.charAt(i), i);
            max = Math.max(end - start + 1, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int a = lengthOfLongestSubstring("aabaabcaa");
//        System.out.println(a);

        HashMap<List<String>, Object> changeMap = new HashMap<>();

        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

    }
}