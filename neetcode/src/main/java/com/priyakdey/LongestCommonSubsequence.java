package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int rows = text1.length() + 1;
        int cols = text2.length() + 1;
        int[][] cache = new int[rows][cols];

        for (int col = 0; col < cols; col++) {
            cache[rows - 1][col] = 0;
        }
        for (int row = 0; row < rows; row++) {
            cache[row][cols - 1] = 0;
        }

        for (int row = rows - 2; row >= 0; row--) {
            for (int col = cols - 2; col >= 0; col--) {
                if (text1.charAt(row) == text2.charAt(col)) {
                    cache[row][col] = 1 + cache[row + 1][col + 1];
                } else {
                    cache[row][col] = Math.max(cache[row + 1][col], cache[row][col + 1]);
                }
            }
        }

        return cache[0][0];
    }

}
