package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class MinPassesOfMatrix {

    // Problem like rotten oranges. Add all positive numbers to the queue.
    // Do a BFS from each node and go to negative nodes.

    public int minimumPassesOfMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        Deque<Cell> queue = new ArrayDeque<>();
        int totalNegatives = 0, converted = 0;

        // Step 1: Add all initially positive cells to the queue
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] > 0) {
                    queue.offer(new Cell(row, col, 0));
                } else if (matrix[row][col] < 0) {
                    totalNegatives++;
                }
            }
        }

        int maxPasses = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Step 2: Perform multi-source BFS
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            int row = cell.row, col = cell.col, passes = cell.passes;
            maxPasses = Math.max(maxPasses, passes);

            for (int[] dir : directions) {
                int newRow = row + dir[0], newCol = col + dir[1];

                if (isValid(newRow, newCol, rows, cols) && matrix[newRow][newCol] < 0) {
                    matrix[newRow][newCol] *= -1;
                    queue.offer(new Cell(newRow, newCol, passes + 1));
                    converted++;
                }
            }
        }

        // Step 3: If some negatives were never converted, return -1
        return (converted == totalNegatives) ? maxPasses : -1;
    }

    private boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    private record Cell(int row, int col, int passes) {
    }

}
