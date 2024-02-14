package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

    public static List<Integer> spiralTraverse(int[][] array) {
        if (array == null || array.length == 0 || array[0] == null || array[0].length == 0) {
            throw new IllegalArgumentException("invalid input");
        }

        int rows = array.length, cols = array[0].length;

        List<Integer> flattenMatrix = new ArrayList<>(rows * cols);

        int i = 0; // Spiral layer level
        int rowBound = (rows + 1) / 2;
        int colBound = (cols + 1) / 2;

        while (i < rowBound && i < colBound) {
            // Traverse from left to right
            for (int col = i; col < cols - i; col++) {
                flattenMatrix.add(array[i][col]);
            }

            // Traverse downwards
            for (int row = i + 1; row < rows - i; row++) {
                flattenMatrix.add(array[row][cols - i - 1]);
            }

            // Make sure we traverse the bottom row only if it's not the same as the top row traversed
            if (rows - 1 - i > i) {
                for (int col = cols - i - 2; col >= i; col--) {
                    flattenMatrix.add(array[rows - i - 1][col]);
                }
            }

            // Make sure we traverse the left column only if it's different from the right column traversed
            if (cols - 1 - i > i) {
                for (int row = rows - i - 2; row > i; row--) {
                    flattenMatrix.add(array[row][i]);
                }
            }

            i++; // Move to the inner spiral
        }

        return flattenMatrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {12, 13, 14, 5},
            {11, 16, 15, 6},
            {10, 9, 8, 7}
        };

        List<Integer> result = spiralTraverse(matrix);
        System.out.println(result);
    }
}
