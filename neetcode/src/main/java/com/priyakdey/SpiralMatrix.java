package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int rowPerimeter = ((rows / 2) + (rows % 2)) - 1;
        int colPerimeter = ((cols / 2) + (cols % 2)) - 1;

        int elementsCount = rows * cols;
        List<Integer> flattenMatrix = new ArrayList<>(elementsCount);

        int rowStart = 0, colStart = 0;

        while (rowStart <= rowPerimeter && colStart <= colPerimeter) {
            for (int col = colStart; col < cols - colStart; col++) {
                flattenMatrix.add(matrix[rowStart][col]);
            }

            for (int row = rowStart + 1; row < rows - colStart; row++) {
                flattenMatrix.add(matrix[row][cols - colStart - 1]);
            }

            if (rows - 1 - rowStart > rowStart) {
                for (int col = cols - 1 - colStart - 1; col >= colStart; col--) {
                    flattenMatrix.add(matrix[rows - rowStart - 1][col]);
                }
            }

            if (cols - 1 - colStart > colStart) {
                for (int row = rows - 1 - rowStart - 1; row >= rowStart + 1; row--) {
                    flattenMatrix.add(matrix[row][colStart]);
                }
            }

            rowStart++;
            colStart++;
        }

        return flattenMatrix;
    }

}
