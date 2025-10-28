package com.priyakdey;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Priyak Dey
 */
public class P3341 {

    public int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length;
        int cols = moveTime[0].length;

        int[][] times = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                times[row][col] = -1;
            }
        }

        int[][] directions = {{1, 0},  {-1, 0}, {0, 1}, {0, -1}};

        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(Cell::time));
        pq.offer(new Cell(0, 0, 0));
        times[0][0] = 0;

        while (!pq.isEmpty()) {
            Cell cell = pq.poll();

            int row = cell.row;
            int col = cell.col;
            int currTime = cell.time;

            for (int[] direction : directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) continue;

                if (times[nextRow][nextCol] == -1 ||
                        currTime + moveTime[nextRow][nextCol] + 1 < times[nextRow][nextCol]) {
                    times[nextRow][nextCol] = currTime + moveTime[nextRow][nextCol] + 1;
                    pq.offer(new Cell(nextRow, nextCol, times[nextRow][nextCol]));
                }
            }
        }

        return times[rows -1][cols -1];

    }

    private record Cell(int row, int col, int time) {
    }

}
