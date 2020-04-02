package ToOffer;

class verifyPostorder {
    public static boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length < 1) return true;
        int n = postorder.length;

        return help(postorder, 0, n - 1);
    }

    public static boolean help(int[] arr, int L, int R){
        if (L >= R){
            return true;
        }
        int i;
        for (i = L; i < R; i++) {
            if (arr[i] > arr[R]) {
                break;
            }
        }
        for (int j = i; j < R; j++) {
            if (arr[j] < arr[R]){
                return false;
            }
        }
        boolean leftresult = help(arr, L, i - 1);
        boolean rightresult = help(arr, i, R - 1);
        return leftresult & rightresult;
    }

    public static void main(String[] args) {
//        int[] arr = {1,3,2,6,5};
        int[] arr = {7,4,6,5};
        boolean result = verifyPostorder(arr);
        System.out.println(result);
    }

}