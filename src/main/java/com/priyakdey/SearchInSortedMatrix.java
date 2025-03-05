package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class SearchInSortedMatrix {

    // Start from [rows - 1, 0] and traverse to right col, if target is
    // greater than current element. Traverse to above row if target is less
    // than current element.

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int row = rows - 1, col = 0;

        while (row >= 0 && col < cols) {
            if (target == matrix[row][col]) {
                return new int[]{row, col};
            } else if (target > matrix[row][col]) {
                col++;
            } else {
                row--;
            }
        }

        return new int[]{-1, -1};
    }

}
