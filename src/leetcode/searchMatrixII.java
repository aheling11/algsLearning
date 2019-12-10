package leetcode;

/**
 * 240. Search a 2D Matrix II
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * Solution 1:创建虚数组，再使用二分查找
 * Solution 2:思路：正常思路从中间开始找，即数字9开始，如果target大就右下，如果target小则左上，可是这种方法太慢,我们从右上角开始找起
 */
class searchMatrixII {

    public void solution(){
//        int[][] matrix = {{1,   4,  7, 11, 15},
//                          {2,   5,  8, 12, 19},
//                          {3,   6,  9, 16, 22},
//                          {10, 13, 14, 17, 24},
//                          {18, 21, 23, 26, 30}};

        int[][] matrix = {{-1,3}};

        System.out.println(searchMatrixTarget02(matrix,-1));
    }

    public boolean searchMatrixTarget01(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            int right =  m - 1;
            int left = 0;
            while (left <= right) {
                int midnum = (right + left)/2;
                int midElement = matrix[i][midnum % m];
                if (target == midElement) {
                    return true;
                } else if (target < midElement) {
                    right = midnum - 1;
                } else {
                    left = midnum + 1;
                }
            }
        }
        return false;
    }
    public boolean searchMatrixTarget02(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0;
        int j = m - 1;

        while (i < n && j >= 0) {
            if (target > matrix[i][j]) {
                i++;
            } else if (target < matrix[i][j]){
                j--;
            } else {
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        searchMatrixII m = new searchMatrixII();
        m.solution();
    }
}