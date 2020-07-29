package ToOffer;

class findNumberIn2DArray {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = 0;
        int j = cols - 1;
        while (i < rows && j > 0) {
            if(matrix[i][j] > target){
                j--;
            } else if(matrix[i][j] < target){
                i++;
            } else if(matrix[i][j] == target){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}};
        int[][] matrix = {{-5}};
        System.out.println(matrix[0].length);
        System.out.println(matrix.length);
        findNumberIn2DArray(matrix, -10);
    }
}