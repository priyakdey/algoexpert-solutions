package com.priyakdey.algoexpersolutions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class RemoveIslands {

    // Mark all 1s connected to the border using BFS and convert the rest (enclosed 1s = islands)
    // to 0. Then restore marked border-connected 1s back to 1.

    public int[][] removeIslands(int[][] matrix) {
        Deque<Cell> queue = new ArrayDeque<>();
        Set<Cell> visited = new HashSet<>();
        int rows = matrix.length, cols = matrix[0].length;

        for (int row = 0; row < rows; row++) {
            if (matrix[row][0] == 1) {
                Cell cell = new Cell(row, 0);
                matrix[row][0] = 2;
                queue.offer(cell);
                visited.add(cell);
            }

            if (matrix[row][cols - 1] == 1) {
                Cell cell = new Cell(row, cols - 1);
                matrix[row][cols - 1] = 2;
                queue.offer(cell);
                visited.add(cell);
            }
        }

        for (int col = 0; col < cols; col++) {
            if (matrix[0][col] == 1) {
                Cell cell = new Cell(0, col);
                matrix[0][col] = 2;
                queue.offer(cell);
                visited.add(cell);
            }

            if (matrix[rows - 1][col] == 1) {
                Cell cell = new Cell(rows - 1, col);
                matrix[rows - 1][col] = 2;
                queue.offer(cell);
                visited.add(cell);
            }
        }

        int[][] directions = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();

            for (int[] direction : directions) {
                int dr = direction[0];
                int dc = direction[1];
                Cell nextCell = cell.next(dr, dc);

                if (nextCell.isInRange(rows, cols) && matrix[nextCell.row][nextCell.col] == 1
                        && !visited.contains(nextCell)) {
                    matrix[nextCell.row][nextCell.col] = 2;
                    queue.offer(nextCell);
                    visited.add(nextCell);
                }
            }
        }

        replace(matrix, 1, 0);
        replace(matrix, 2, 1);
        return matrix;
    }

    private void replace(int[][] matrix, int replace, int replaceWith) {
        int rows = matrix.length, cols = matrix[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == replace) {
                    matrix[row][col] = replaceWith;
                }
            }
        }

    }

    private record Cell(int row, int col) {

        public Cell next(int dr, int dc) {
            return new Cell(row + dr, col + dc);
        }

        public boolean isInRange(int rows, int cols) {
            return this.row >= 0 && this.row < rows && this.col >= 0 && this.col < cols;
        }

    }

}
