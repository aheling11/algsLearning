package ToOffer;

import java.util.Stack;

class exist {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int[][] hasPassed = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (findTarget(chars, board, hasPassed, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findTarget(char[] chars, char[][] board, int[][] hasPassed, int p, int i, int j) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || hasPassed[i][j] == 1 || board[i][j] != chars[p]) {
            return false;
        }
        if (p == chars.length - 1) return true;
        hasPassed[i][j] = 1;
        boolean res =
                findTarget(chars, board, hasPassed, p + 1, i + 1, j) ||
                findTarget(chars, board, hasPassed, p + 1, i - 1, j) ||
                findTarget(chars, board, hasPassed, p + 1, i, j + 1) ||
                findTarget(chars, board, hasPassed, p + 1, i, j - 1);
        hasPassed[i][j] = 0;
        return res;
    }
}