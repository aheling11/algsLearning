package ToOffer;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

class firstUniqChar {
    public static char firstUniqChar(String s) {
        int[] map = new int[128];
        char[] chars = s.toCharArray();
        for(char c : chars){
            map[c]++;
        }
        for(char c : chars){
            if (map[c] == 1){
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        char leqwewe = firstUniqChar("leqwewe");
        System.out.println(leqwewe);
    }
}