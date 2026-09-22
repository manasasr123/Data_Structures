class Solution {

    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == word.charAt(0)) {

                    if (search(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean search(char[][] board, String word,
                          int row, int col, int index) {

        // All characters matched
        if (index == word.length()) {
            return true;
        }

        // Out of bounds
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }

        // Character doesn't match
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark current cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        // Search in 4 directions
        boolean found =
            search(board, word, row - 1, col, index + 1) || // up
            search(board, word, row + 1, col, index + 1) || // down
            search(board, word, row, col - 1, index + 1) || // left
            search(board, word, row, col + 1, index + 1);   // right

        // Backtrack
        board[row][col] = temp;

        return found;
    }
}