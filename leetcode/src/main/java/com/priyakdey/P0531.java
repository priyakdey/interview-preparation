package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P0531 {

    public int findLonelyPixel(char[][] picture) {
        int rows = picture.length;
        int cols = picture[0].length;

        int lonely = 0;

        for (int row = 0; row < rows; row++) {
            int c = -1;
            for (int col = 0; col < cols; col++) {
                // check for "B" in the row
                if  (picture[row][col] == 'B') {
                    if (c != -1) {
                        c = -1;
                        break;
                    }
                    c = col;
                }
            }

            if (c == -1) continue;

            int count = 0;
            for (int r = 0; r < rows; r++) {
                if (picture[r][c] == 'B') count++;
            }

            if (count == 1) {
                lonely++;
            }
        }

        return lonely;
    }

}
