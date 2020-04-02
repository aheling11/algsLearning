package ToOffer;

import java.util.*;

class minNumber {

    static class Number implements Comparable<Number>{
        int data;
        public Number(int num){
            this.data = num;
        }
        @Override
        public int compareTo(Number mnumber) {
            int n = data;
            int m = mnumber.data;
            String nm = String.valueOf(n) + m;
            String mn = String.valueOf(m) + n;
            return nm.compareTo(mn);
        }
    }

    public static String minNumber(int[] nums) {
        Number[] Numbers = new Number[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Numbers[i] = new Number(nums[i]);
        }
        Arrays.sort(Numbers);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Numbers.length; i++) {
            sb.append(Numbers[i].data);
        }
        return sb.toString();
    }

    public static String minNumber_2(int[] nums) {
        List<String> list = new ArrayList<>();
        for(int num : nums){
            list.add(String.valueOf(num));
        }

        list.sort((s1 , s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for(String str : list){
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        int nums[] = {3,1,534,100,243,999999999};
        System.out.println(minNumber_2(nums));
    }
}