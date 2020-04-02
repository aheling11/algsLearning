package ToOffer;

import java.util.Stack;

class myPow {
    public double myPow(double x, int n) {
        double base = x;
        double ans = 1;
        long t = n;
        if (t < 0) {
            t = ~t + 1;
        }
        while(t != 0){
            if((t & 1) == 1) {
                ans *= base;
            } 
            base  = base * base;
            t >>= 1;
        }


        Stack<Integer> stack = new Stack<>();
        return n < 0 ? 1 / ans : ans;
    }
}