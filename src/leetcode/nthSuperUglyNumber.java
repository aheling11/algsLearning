package leetcode;

class nthSuperUglyNumber {
    public static int[] nthSuperUglyNumber(int n, int[] primes) {
        int length = primes.length;
        int[] m = new int[length]; //
        int[] t = new int[length];
        int[] output = new int[n];
        output[0] = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < length; j++){
                for(int k = t[j]; k < i; k++) {
                    if(output[k] * primes[j] > output[i - 1]){
                        m[j] = output[k] * primes[j];
                        t[j] = k;
                        break;
                    }
                }
            }
            int min = getMin(m);
            output[i] = min;
        }
        return output;
    }

    public static int getMin(int[] arr){
        int min = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = nthSuperUglyNumber(12, new int[]{2, 7, 13, 19});
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}