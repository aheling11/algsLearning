package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class cutRope {
    public static int cutRope(String s) {
        TreeSet<Integer> arr = new TreeSet<>();
        StringBuilder result = new StringBuilder();
        String[] split = s.split(",");
        for (int i = 0; i < split.length; i++) {
            int t = Integer.parseInt(split[i]);
            if (isPrime(t)){
                arr.add(t);
            }
        }

        result.append(arr.pollFirst());
        while (!arr.isEmpty()){
            result.append(",");
            result.append(arr.pollFirst());
        }

        System.out.println(result);
        return 1;

    }


    public static boolean isPrime(int n) {
        if (n <= 3) {
            return n > 1;
        }
        int sqrt = (int)Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{5, 4, 3, 6};
        String arr = "5,3,4,6";
        System.out.println(Math.pow(2,3));
        cutRope(arr);
    }
}