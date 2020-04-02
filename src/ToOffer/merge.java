package ToOffer;

class merge {
    public static void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while(i >= 0){
            if(A[i] != 0) break;
            i--;
        }
        while(i >= 0 && j >= 0){
            if(A[i] > B[j]){
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }
        while(i >= 0){
            A[k--] = A[i--];
        }
        while(j >= 0){
            A[k--] = A[j--];
        }
    }

    public static void main(String[] args) {
        merge(new int[]{0},0,new int[]{1}, 1);
    }
}