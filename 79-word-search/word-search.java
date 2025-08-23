class Solution {
    private int m, n;

    private boolean find(char[][] board, int i, int j, int ind, String word) {
        int[][] directions = {
            {1, 0},  // down
            {-1, 0}, // up
            {0, 1},  // right
            {0, -1}  // left
        };
        if (ind == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '$') {
            return false;
        }
        if (board[i][j] != word.charAt(ind)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '$';
        for (int[] dir : directions) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];

            if (find(board, new_i, new_j, ind + 1, word)) {
                return true;
            }
        }
        board[i][j] = temp;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && find(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
}
