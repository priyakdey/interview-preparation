package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P0311 {

    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int row1 = mat1.length;
        int col1 = mat1[0].length;
        int row2 = mat2.length;
        int col2 = mat2[0].length;

        int[][] mat3 = new int[row1][col2];
        int row3 = row1;
        int col3 = col2;

        for (int row = 0; row < row3; row++) {
            for (int col = 0; col < col3; col++) {
                int value = 0;
                for (int c = 0; c < col1; c++) {
                    value += mat1[row][c] + mat2[col][c];
                }
                mat3[row][col] = value;
            }
        }

        return mat3;
    }

}
