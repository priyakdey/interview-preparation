package com.priyakdey.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class CountSquares {

    // IF P1(x1, y1) and P2(x2, y2) are two diagonal points, the other points are:
    // P3 = ( (x1 + x2 + (y1 - y2)) / 2 , (y1 + y2 + (x2 - x1)) / 2 )
    // P4 = ( (x1 + x2 - (y1 - y2)) / 2 , (y1 + y2 - (x2 - x1)) / 2 )

    // We pack two int32 into an int64 for lightweight keys.
    // Then add all points to the set, we double each coordinate so that we don't need to
    // divide by 2 to avoid fraction calculation.

    // (x << 32) ^ (y & 0xFFFFFFFFL)
    // Upper 32 bits of the 64 bit int is taken by x.
    // The lower 32 bits are taken by y. Since y can be negative, and 2's complement going to fill
    // up the entire upper half with 1, we clear it and convert it into unsigned number.
    // To convert an int_x into an uint_x, we can do int_x & ((1<<x) - 1)

    public int countSquares(int[][] points) {
        long count = 0;

        Set<Long> set = new HashSet<>();
        for (int[] point : points) {
            // double each point to avoid divide by 2
            long key = key(2L * point[0], 2L * point[1]);
            set.add(key);
        }

        for (int i = 0; i < points.length - 1; i++) {
            long x1 = points[i][0], y1 = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                long x2 = points[j][0], y2 = points[j][1];

                long x3 = ((x1 + x2) + (y1 - y2));
                long y3 = ((y1 + y2) + (x2 - x1));

                long x4 = ((x1 + x2) - (y1 - y2));
                long y4 = ((y1 + y2) - (x2 - x1));

                long p3 = key(x3, y3);
                long p4 = key(x4, y4);

                if (set.contains(p3) && set.contains(p4)) {
                    count++;
                }
            }
        }

        return (int) count / 2;
    }

    // Pack two integers into a single long
    private long key(long x, long y) {
        return (x << 32) ^ (y & 0xFFFFFFFFL);
    }

}
