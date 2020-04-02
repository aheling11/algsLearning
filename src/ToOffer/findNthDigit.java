package ToOffer;

class findNthDigit {
    public static long findNthDigit(int n) {
        //位数
        long N = n;
        long digit = 1;
        while(true){
            //要跳过的数字个数
           long numbers = countOflongeger(digit);
           //要跳过的数字下标
           if (digit * numbers > N){
               return findTheDigit(N, digit);
           }
            N -= digit * numbers;
           digit++;
        }
    }

    private static long findTheDigit(long n, long digit) {
        long beginNumber = digit == 1 ? 0 : (long) Math.pow(10, digit - 1);
        long number = beginNumber + n / digit;
        long indexFromRight = digit - n % digit;
        for (long i = 1; i < indexFromRight; i++) {
            number /= 10;
        }
        return number % 10;
    }

    private static long countOflongeger(long digit) {
        long result;
        if (digit == 1){
            result = 10;
        } else {
            result = 9 * (long)Math.pow(10, digit - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        long nthDigit = findNthDigit(1000000000);
        System.out.println(nthDigit);
    }
}