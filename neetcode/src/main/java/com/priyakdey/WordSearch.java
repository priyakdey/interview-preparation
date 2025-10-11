package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (exist(board, row, col, rows, cols, word, 0, directions)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean exist(char[][] board, int row, int col, int rows, int cols,
                          String word, int index, int[][] directions) {
        if (index == word.length()) return true;
        if (row < 0 || row >= rows || col < 0 || col >= cols) return false;

        char ch = board[row][col];
        if (ch != word.charAt(index)) return false;

        board[row][col] = '.';

        boolean canExist = false;

        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (exist(board, nextRow, nextCol, rows, cols, word, index + 1, directions)) {
                canExist = true;
                break;
            }
        }

        board[row][col] = ch;
        return canExist;
    }

}
