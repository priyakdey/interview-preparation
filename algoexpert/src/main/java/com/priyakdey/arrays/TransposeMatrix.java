package com.priyakdey.arrays;

/**
 * @author Priyak Dey
 */
public class TransposeMatrix {

    // Create a new matrix of size cols * rows.
    // Iterate over original matrix, and copy values making sure
    // elements from [row][col] goes into [col][row]

    public int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] transpose = new int[cols][rows];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                transpose[col][row] = matrix[row][col];
            }
        }

        return transpose;
    }

}
