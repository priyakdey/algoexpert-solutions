package com.priyakdey;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class RiverSizes {

    // Like connected components, BFS from cells which are water.

    public static List<Integer> riverSizes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;

        List<Integer> sizes = new ArrayList<>();
        Deque<Cell> queue = new ArrayDeque<>();
        Set<Cell> visited = new HashSet<>();

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Cell cell = new Cell(row, col);
                if (visited.contains(cell) || matrix[row][col] == 0) {
                    continue;
                }

                queue.offer(cell);
                visited.add(cell);
                int size = 0;

                while (!queue.isEmpty()) {
                    Cell current = queue.poll();
                    size++;

                    int r = current.row, c = current.col;

                    for (int[] direction : directions) {
                        int newRow = r + direction[0], newCol = c + direction[1];
                        Cell e = new Cell(newRow, newCol);
                        if (isValid(newRow, newCol, rows, cols) && matrix[newRow][newCol] == 1 && !visited.contains(e)) {
                            queue.offer(e);
                            visited.add(e);
                        }
                    }
                }

                sizes.add(size);
            }
        }

        return sizes;
    }

    private static boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    private record Cell(int row, int col) {
    }

}
