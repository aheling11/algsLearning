package Test;

public class Fibonacci {

    int[] memo;
    int n = 0;
    Fibonacci(int n) {
        memo = new int[n+1];
        this.n = n;
    }

    public int procesFib() {
        return fib(n);
    }
    public int fib(int n) {
        if (memo[n]!=0) {
            return memo[n];
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int result = fib(n-1) + fib(n-2);
        memo[n] = result;
        return result;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    // 1 1 2 3 5 8 13
    public static void main(String[] args) {
        Fibonacci f = new Fibonacci(40);
        System.out.println(f.procesFib());
//        printArray(f.memo);
    }

}
