package leetcode;

/**
 * LeetCode74. Search a 2D Matrix
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * Solution:
 * 创建虚数组，再使用二分查找
 */
class searchMatrix {

    public void solution(){
        int[][] matrix = {{1,  3,  5,  7},
                         {10, 11, 16, 20},
                         {23, 30, 34, 50}};

        System.out.println(searchMatrixTarget01(matrix,16));
    }

    public boolean searchMatrixTarget01(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int right = n * m - 1;
        int left = 0;
        while (left <= right) {
            int midnum = (right + left)/2;
            int midElement = matrix[midnum / m][midnum % m];
            if (target == midElement) {
                return true;
            } else if (target < midElement) {
                right = midnum - 1;
            } else {
                left = midnum + 1;
            }
        }
        return false;
    }
    public boolean searchMatrixTarget02(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        System.out.println();


        return false;
    }



    public static void main(String[] args) {
        searchMatrix m = new searchMatrix();
        m.solution();
    }
}