package Bishi.Alibaba.网易0911;


import java.util.Arrays;

class findTheLongestSubstring {
    public static int findTheLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int[] pre= new int[50];
        Arrays.fill(pre, Integer.MAX_VALUE);
        pre[0] = -1;
        int cur = 0;
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]){
                case 'a': cur ^= 1; break;
                case 'e': cur ^= 2; break;
                case 'i': cur ^= 4; break;
                case 'o': cur ^= 8; break;
                case 'u': cur ^= 16; break;
                default:break;
            }
            if (pre[cur] == Integer.MAX_VALUE) {
                pre[cur] = i;
            } else {
                res = Math.max(res, i - pre[cur]);
            }
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        String s = "leetcodeisgreaaet";
        findTheLongestSubstring(s);
    }
}