package leetcode;

public class NumberOf1 {
    public static int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0){
            cnt++;
            n = (n - 1) & n;
        }
        System.out.println(cnt);
        return cnt;
    }

    public static void main(String[] args) {

        System.out.println(Integer.toBinaryString(-5));
        NumberOf1(-5);
    }
}