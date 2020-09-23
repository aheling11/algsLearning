package leetcode;

class exist {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int index = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, chars, index, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] chars, int index, int i, int j) {
        if (index == chars.length){
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '-'){
            return false;
        }
        if (board[i][j] != chars[index]){
            return false;
        }
        char t = board[i][j];
        board[i][j] = '-';
        boolean res = dfs(board, chars, index + 1, i + 1, j) ||
                dfs(board, chars, index + 1, i - 1, j) ||
                dfs(board, chars, index + 1, i, j + 1) ||
                dfs(board, chars, index + 1, i, j - 1);
        board[i][j] = t;

        return res;
    }




}