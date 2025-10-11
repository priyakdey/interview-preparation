package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int islands = 0;
        Deque<Cell> queue = new ArrayDeque<>();

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] != '1') continue;

                islands++;

                queue.offer(new Cell(row, col));
                grid[row][col] = '2';

                while (!queue.isEmpty()) {
                    Cell cell = queue.poll();

                    for (int[] direction : directions) {
                        Cell nextCell = cell.next(direction);
                        if (nextCell.inRange(rows, cols)
                                && grid[nextCell.row][nextCell.col] == '1') {
                            queue.offer(nextCell);
                            grid[nextCell.row][nextCell.col] = '2';
                        }
                    }
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '2') {
                    grid[row][col] = '1';
                }
            }
        }

        return islands;
    }

    private record Cell(int row, int col) {

        private Cell next(int[] direction) {
            return new Cell(row + direction[0], col + direction[1]);
        }

        private boolean inRange(int rows, int cols) {
            return row >= 0 && row < rows && col >= 0 && col < cols;
        }
    }

}
