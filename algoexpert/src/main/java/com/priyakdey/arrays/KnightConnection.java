package com.priyakdey.arrays;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class KnightConnection {

    // Use a Queue to try a BFS method, since most of the possible directions are moot, BFS is
    // better so we don't get lost trying to explore one single direction.
    // Treat as a sing source BFS in a matrix.
    // Move one knight till it reaches the other knight.
    // Once there, total (movements of knight A + 1) / 2 is the ans.

    // TODO: this is memory intensive, probably a better maths oriented solution
    // is feasible.

    public int knightConnection(int[] knightA, int[] knightB) {
        int[][] directions = new int[][]{{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

        Knight _knightA = new Knight(knightA[0], knightA[1], 0);
        Knight _knightB = new Knight(knightB[0], knightB[1], 0);

        Deque<Knight> queue = new ArrayDeque<>();
        Set<Knight> visited = new HashSet<>();
        queue.offer(_knightA);
        visited.add(_knightA);

        while (!queue.isEmpty()) {
            Knight knight = queue.poll();
            if (Objects.equals(knight, _knightB)) {
                return (knight.count + 1) / 2;
            }

            for (int[] direction : directions) {
                // We are also going back to the original position, we can avoid using a set.
                // For now, we overlook this.
                Knight move = knight.move(direction[0], direction[1]);
                if (!visited.contains(move)) {
                    queue.offer(move);
                    visited.add(move);

                }
            }
        }

        return -1;
    }

    private record Knight(int x, int y, int count) {

        private Knight move(int dx, int dy) {
            return new Knight(x + dx, y + dy, count + 1);
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Knight knight = (Knight) o;
            return x == knight.x && y == knight.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
