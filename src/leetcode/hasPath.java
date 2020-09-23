package leetcode;

public class hasPath {
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] visited = new boolean[matrix.length];
        int pathcnt = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathprocess(matrix, rows, cols, i, j, str, visited, pathcnt)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean hasPathprocess(char[] matrix, int rows, int cols, int row, int col, char[] str, boolean[] visited, int pathcnt){
        if (pathcnt == str.length){
            return true;
        }
        boolean result = false;
        if (row >= 0 && row < rows && col >=0 && col < cols && matrix[row * cols + col] == str[pathcnt] && !visited[row * cols + col]){
            pathcnt++;
            visited[row * cols + col] = true;
            result = hasPathprocess(matrix, rows, cols, row + 1, col, str, visited, pathcnt)
                    || hasPathprocess(matrix, rows, cols, row - 1, col, str, visited, pathcnt)
                    || hasPathprocess(matrix, rows, cols, row, col + 1, str, visited, pathcnt)
                    || hasPathprocess(matrix, rows, cols, row, col - 1, str, visited, pathcnt);
            if (!result){
                visited[row * cols + col] = false;
            }
        }
        return result;
    }



    public static void main(String[] args) {
        //a b c.cpp e s f c.cpp s a d e e
        char[] matrix = new char[]{'a','b','c','e','s','f','c','s','a','d','e','e'};
        int rows = 3;
        int cols = 4;
        String str = "bccse";
        boolean a = hasPath(matrix, rows, cols, str.toCharArray());
        System.out.println(a);
    }


}