package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // find the row - O(log m)
        int row = -1;
        int up = 0, down = rows - 1;

        while (up <= down) {
            int mid = up + (down - up) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][cols - 1]) {
                row = mid;
                break;
            } else if (target < matrix[mid][0]) {
                down = mid - 1;
            } else {
                up = mid + 1;
            }
        }

        if (row == -1) return false;


        // find the row - O(log n)
        int col = -1;
        int left = 0, right = cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == matrix[row][mid]) {
                col = mid;
                break;
            } else if (target < matrix[row][mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return col != -1;
    }

}
