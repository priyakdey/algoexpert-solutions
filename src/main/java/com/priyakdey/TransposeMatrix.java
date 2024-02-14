package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class TransposeMatrix {

    public int[][] transposeMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            throw new IllegalArgumentException("invalid input");
        }

        int rows = matrix.length, cols = matrix[0].length;
        int[][] transposedMatrix = new int[cols][rows];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                transposedMatrix[col][row] = matrix[row][col];
            }
        }

        return transposedMatrix;
    }

}
