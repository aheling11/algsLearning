package leetcode;

import java.util.HashMap;

/**
 * 3. Longest Substring Without Repeating Characters
 */
class lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> hashMap = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))){
                left = Math.max(hashMap.get(s.charAt(i)) + 1, left);

            }
            hashMap.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);


        }
        return max;
    }



    public static void main(String[] args) {
        String string = "abcbabc";
        System.out.println(lengthOfLongestSubstring(string));
    }
}