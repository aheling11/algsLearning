package leetcode;

public class movingCount {
    public static int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        int count = movingprocess(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    public static int movingprocess(int threshold, int rows, int cols, int row, int col, boolean[][] visited){
        int sum = getsumofcnt(row) + getsumofcnt(col);
        int result = 0;
        if (sum > threshold){
            return result;
        } else if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row][col]){
            visited[row][col] = true;

            result = movingprocess(threshold, rows, cols, row + 1, col, visited)
                    + movingprocess(threshold, rows, cols, row - 1, col, visited)
                    + movingprocess(threshold, rows, cols, row, col + 1, visited)
                    + movingprocess(threshold, rows, cols, row, col - 1, visited);
            result += 1;

        }
        return result;
    }

    public static int getsumofcnt(int x){
        int sum = 0;
        while(x != 0){
            sum += x%10;
            x/=10;
        }
        return sum;
    }
    public static void main(String[] args) {
        int count = movingCount(3, 4, 4);
        System.out.println(count);
    }
}