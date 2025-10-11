package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];

        for (int row = 0; row < m; row++) {
            matrix[row][n - 1] = 1;
        }

        for (int col = 0; col < n; col++) {
            matrix[m - 1][col] = 1;
        }

        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                matrix[row][col] = matrix[row + 1][col] + matrix[row][col + 1];
            }
        }

        return matrix[0][0];
    }

}
