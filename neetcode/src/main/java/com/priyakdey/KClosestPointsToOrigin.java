package com.priyakdey;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Priyak Dey
 */
public class KClosestPointsToOrigin {

    // Use a max heap to keep track of k closest elements.
    // During iteration, if one element has less distance that the one
    // at the root, insert.

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(k,
                Comparator.comparingLong(Point::distance).reversed());

        for (int[] point : points) {
            long distance = calcDistance(point);
            Point p = new Point(point, distance);
            if (pq.size() == k) {
                Point _p = pq.poll();
                if (_p.distance < p.distance) {
                    p = _p;
                }
            }
            pq.offer(p);
        }

        int[][] result = new int[k][2];
        int cursor = 0;
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            result[cursor++] = p.point;
        }

        return result;
    }

    private long calcDistance(int[] point) {
        long x = point[0];
        long y = point[1];

        return (x * x) + (y * y);
    }

    private record Point(int[] point, long distance) {
    }


}
