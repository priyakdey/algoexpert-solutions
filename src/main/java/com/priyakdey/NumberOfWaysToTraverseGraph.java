package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class NumberOfWaysToTraverseGraph {

    // Create the graph and use dp at each cell to determine number of ways to
    // reach destination

    public int numberOfWaysToTraverseGraph(int width, int height) {
        int[][] matrix = new int[height][width];

        matrix[height - 1][width - 1] = 1;

        for (int row = 0; row < height - 1; row++) {
            matrix[row][width - 1] = 1;
        }
        for (int col = 0; col < width - 1; col++) {
            matrix[height - 1][col] = 1;
        }

        for (int row = height - 2; row >= 0; row--) {
            for (int col = width - 2; col >= 0; col--) {
                matrix[row][col] = matrix[row + 1][col] + matrix[row][col + 1];
            }
        }

        return matrix[0][0];
    }

}
