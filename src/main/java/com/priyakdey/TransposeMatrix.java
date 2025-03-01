package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class TransposeMatrix {

    // Create a new matrix with cols * rows dimension. Fill it up by
    // iteration over original matrix.

    public int[][] transposeMatrix(int[][] matrix) {
        assert matrix != null && matrix.length != 0 && matrix[0] != null;

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
