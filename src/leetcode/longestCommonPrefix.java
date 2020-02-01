package leetcode;

import java.util.Arrays;

class longestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length < 1){
            return "";
        }
        int index = 0;
        while (index < strs[0].length()){
            char cur = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if(strs[i].length() < index+1){
                    return strs[i];
                }
                if (cur != strs[i].charAt(index)){                        
                    return strs[0].substring(0, index);
                }
            }
            index++;
        }

        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = {"aaaa","aa"};
        System.out.println(longestCommonPrefix(strs));
    }
}