package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        boolean isFirstRow = false;
        boolean isFirstCol = false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int col = 0; col < cols; col++) {
            if (matrix[0][col] == 0) {
                isFirstRow = true;
                break;
            }
        }
        
        for (int row = 0; row < rows; row++) {
            if (matrix[row][0] == 0) {
                isFirstCol = true;
                break;
            }
        }
        
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }
        
        // set all rows
        for (int row = 1; row < rows; row++) {
            if (matrix[row][0] == 0) {
                for (int col = 1; col < cols; col++) {
                    matrix[row][col] = 0;
                }
            }
        }
        
        // set all cols
        for (int col = 1; col < cols; col++) {
            if (matrix[0][col] == 0) {
                for (int row = 1; row < rows; row++) {
                    matrix[row][col] = 0;
                }
            }
        }
        
        if (isFirstRow) {
            for  (int col = 0; col < cols; col++) {
                matrix[0][col] = 0;
            }
        }
        
        if (isFirstCol) {
            for  (int row = 0; row < rows; row++) {
                matrix[row][0] = 0;
            }
        }
    }

}
