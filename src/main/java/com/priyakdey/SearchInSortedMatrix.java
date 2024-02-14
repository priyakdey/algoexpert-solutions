package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class SearchInSortedMatrix {

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            throw new IllegalArgumentException("invalid input");
        }

        int rows = matrix.length, cols = matrix[0].length;

        int row = rows - 1, col = 0;
        int[] cell = new int[] {-1, -1};

        while (row >= 0 && col < cols) {
            if (target == matrix[row][col]) {
                cell[0] = row;
                cell[1] = col;
                break;
            } else if (target > matrix[row][col]) {
                col = col + 1;
            } else {
                row = row - 1;
            }
        }

        return cell;
    }

}
