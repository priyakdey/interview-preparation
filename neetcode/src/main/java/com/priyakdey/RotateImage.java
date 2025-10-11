package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = row; col < cols; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        for (int row = 0; row < rows; row++) {
            int left = 0, right = cols - 1;
            while (left < right) {
                int temp = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = temp;
                left++;
                right--;
            }
        }
    }

}
