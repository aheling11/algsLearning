package ToOffer;

import java.util.ArrayList;

class reverseLeftWords {
    public String reverseLeftWords(String s, int n) {

        return s.substring(n) + s.substring(0,2);
    }

    public static void main(String[] args) {

        String s = "abcdefg";
        System.out.println(s.substring(0, 2));
        System.out.println(s.substring(2));
        ArrayList<Integer> a = new ArrayList<>();
    }
}