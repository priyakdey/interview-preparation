package com.priyakdey;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class PacificAtlanticWaterFlow {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        Deque<Cell> queue = new ArrayDeque<>();


        boolean[][] matrix1 = canFlowToPacific(heights, rows, cols, queue);
        queue.clear();
        boolean[][] matrix2 = canFlowToAtlantic(heights, rows, cols, queue);


        List<List<Integer>> res = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix1[row][col] && matrix2[row][col]) {
                    res.add(List.of(row, col));
                }
            }
        }

        return res;
    }

    private boolean[][] canFlowToPacific(int[][] heights, int rows, int cols, Deque<Cell> queue) {
        boolean[][] canFlowMatrix = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            canFlowMatrix[row][0] = true;
            queue.offer(new Cell(row, 0));
        }

        for (int col = 0; col < cols; col++) {
            canFlowMatrix[0][col] = true;
            queue.offer(new Cell(0, col));
        }

        bfs(queue, rows, cols, heights, canFlowMatrix);
        return canFlowMatrix;
    }

    private boolean[][] canFlowToAtlantic(int[][] heights, int rows, int cols, Deque<Cell> queue) {
        boolean[][] canFlowMatrix = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            canFlowMatrix[row][cols - 1] = true;
            queue.offer(new Cell(row, cols - 1));
        }

        for (int col = 0; col < cols; col++) {
            canFlowMatrix[rows - 1][col] = true;
            queue.offer(new Cell(rows - 1, col));
        }

        bfs(queue, rows, cols, heights, canFlowMatrix);
        return canFlowMatrix;
    }

    private void bfs(Deque<Cell> queue, int rows, int cols, int[][] heights, boolean[][] matrix) {
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            int row = cell.row, col = cell.col;

            for (int[] direction : directions) {
                Cell nextCell = cell.next(direction);
                int nextRow = nextCell.row;
                int nextCol = nextCell.col;
                if (nextCell.inRange(rows, cols) && !matrix[nextRow][nextCol]
                        && heights[nextRow][nextCol] >= heights[row][col]) {
                    matrix[nextRow][nextCol] = true;
                    queue.offer(new Cell(nextRow, nextCol));
                }
            }
        }
    }

    private record Cell(int row, int col) {

        private Cell next(int[] direction) {
            return new Cell(this.row + direction[0], this.col + direction[1]);
        }

        private boolean inRange(int rows, int cols) {
            return row >= 0 && row < rows && col >= 0 && col < cols;
        }
    }

}
