package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P0348 {

    private final int[][] board;
    private final int n;

    public P0348(int n) {
        this.board = new int[n][n];
        this.n = n;
    }

    public int move(int row, int col, int player) {
        board[row][col] = player;

        if (checkRow(row, player) != 0) {
            return player;
        }

        if (checkCol(col, player) != 0) {
            return player;
        }

        if (checkMainDiagonal(player) != 0) {
            return player;
        }

        if (checkAntiDiagonal(player) != 0) {
            return player;
        }

        return 0;
    }

    private int checkRow(int row, int player) {
        for (int col = 0; col < n; col++) {
            if (board[row][col] != player) {
                return 0;
            }
        }

        return player;
    }

    private int checkCol(int col, int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][col] != player) {
                return 0;
            }
        }

        return player;
    }

    private int checkMainDiagonal(int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][row] != player) {
                return 0;
            }
        }

        return player;
    }

    private int checkAntiDiagonal(int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][n - 1 - row] != player) {
                return 0;
            }
        }

        return player;
    }

}
