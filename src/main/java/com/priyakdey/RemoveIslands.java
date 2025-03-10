package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class RemoveIslands {

    // Iterate over the edges and queue up all cells which has 1.
    // Perform BFS from those cells and mark all islands with one cell on the
    // edge with -1.
    // Once done, iterate over the matrix row by column, and then
    // mark the -1 back to 1, and the cells marked as 1 to 0.

    public int[][] removeIslands(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;

        Deque<Pair> queue = new ArrayDeque<>();
        Set<Pair> visited = new HashSet<>();

        for (int row = 0; row < rows; row++) {
            Pair pair1 = new Pair(row, 0);
            if (matrix[row][0] == 1) {
                queue.offer(pair1);
                visited.add(pair1);
            }
            Pair pair2 = new Pair(row, cols - 1);
            if (matrix[row][cols - 1] == 1) {
                queue.offer(pair2);
                visited.add(pair2);
            }
        }

        for (int col = 0; col < cols; col++) {
            Pair pair1 = new Pair(0, col);
            if (matrix[0][col] == 1) {
                queue.offer(pair1);
                visited.add(pair1);
            }
            Pair pair2 = new Pair(rows - 1, col);
            if (matrix[rows - 1][col] == 1) {
                queue.offer(pair2);
                visited.add(pair2);
            }
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int row = pair.row, col = pair.col;
            matrix[row][col] = -1;

            addCellToQueue(row, col + 1, rows, cols, matrix, queue, visited);
            addCellToQueue(row + 1, col, rows, cols, matrix, queue, visited);
            addCellToQueue(row, col - 1, rows, cols, matrix, queue, visited);
            addCellToQueue(row - 1, col, rows, cols, matrix, queue, visited);
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == -1) {
                    matrix[row][col] = 1;
                } else if (matrix[row][col] == 1) {
                    matrix[row][col] = 0;
                }
            }
        }

        return matrix;
    }

    private void addCellToQueue(int row, int col, int rows, int cols,
                                int[][] matrix, Deque<Pair> queue,
                                Set<Pair> visited) {
        Pair pair = new Pair(row, col);
        if (pair.isValid(rows, cols) && matrix[row][col] == 1 && !visited.contains(pair)) {
            queue.offer(pair);
            visited.add(pair);
        }
    }

    private record Pair(int row, int col) {

        public boolean isValid(int rows, int cols) {
            return row >= 0 && row < rows && col >= 0 && col < cols;
        }

    }

}
