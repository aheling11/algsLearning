package leetcode;

import java.util.HashMap;

class firstUniqChar {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (hashMap.containsKey(cur)){
                hashMap.put(cur, hashMap.get(cur) + 1);
            } else {
                hashMap.put(cur, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));

    }
}