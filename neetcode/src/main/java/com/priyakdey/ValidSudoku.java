package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ValidSudoku {

    // TODO: Below is the compact implementation of this:
    //
    // class ValidSudoku {
    //
    //     public boolean isValidSudoku(char[][] board) {
    //         return isValid(board, 9, 9, (i, j) -> new int[]{i, j}) // rows
    //                 && isValid(board, 9, 9, (i, j) -> new int[]{j, i}) // columns
    //                 && isValid(board, 9, 9, (i, j) -> new int[]{(i / 3) * 3 + j / 3, (i % 3) * 3 + j % 3}); // boxes
    //     }
    //
    //     private boolean isValid(char[][] board, int outer, int inner, CellProvider provider) {
    //         for (int i = 0; i < outer; i++) {
    //             int bitmap = 0;
    //             for (int j = 0; j < inner; j++) {
    //                 int[] cell = provider.getCell(i, j);
    //                 int row = cell[0], col = cell[1];
    //                 if (board[row][col] == '.') continue;
    //                 int idx = board[row][col] - '1';
    //                 if (((bitmap >> idx) & 1) == 1) return false;
    //                 bitmap |= (1 << idx);
    //             }
    //         }
    //         return true;
    //     }
    //
    // }
    //
    // interface CellProvider {
    //     int[] getCell(int i, int j);
    // }
    //
     // We need to do a profiling before we start shitting on Functional and OOPs!

    public boolean isValidSudoku(char[][] board) {
        return isValidRows(board) && isValidCols(board) && isValidBox(board);
    }

    private boolean isValidRows(char[][] board) {
        for (int row = 0; row < 9; row++) {
            int bitmap = 0;
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') continue;
                int i = board[row][col] - '1';
                if (((bitmap >> i) & 1) == 1) return false;
                bitmap = bitmap | (1 << i);
            }
        }

        return true;
    }

    private boolean isValidCols(char[][] board) {
        for (int col = 0; col < 9; col++) {
            int bitmap = 0;
            for (int row = 0; row < 9; row++) {
                if (board[row][col] == '.') continue;
                int i = board[row][col] - '1';
                if (((bitmap >> i) & 1) == 1) return false;
                bitmap = bitmap | (1 << i);
            }
        }

        return true;
    }

    private boolean isValidBox(char[][] board) {
        for (int row = 0; row < 9; row = row + 3) {
            for (int col = 0; col < 9; col = col + 3) {
                int bitmap = 0;
                for (int r = row; r < row + 3; r++) {
                    for (int c = col; c < col + 3; c++) {
                        if (board[r][c] == '.') continue;
                        int i = board[r][c] - '1';
                        if (((bitmap >> i) & 1) == 1) return false;
                        bitmap = bitmap | (1 << i);
                    }
                }
            }
        }

        return true;
    }

}
