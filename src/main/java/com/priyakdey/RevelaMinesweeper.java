package com.priyakdey;

import java.util.Objects;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class RevelaMinesweeper {


    // Count number of mines for moore's neighbours and then if zero, recurse
    // down the board to reveal other "H".

    public String[][] revealMinesweeper(String[][] board, int row, int column) {
        if (Objects.equals(board[row][column], "M")) {
            board[row][column] = "X";
            return board;
        }

        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        revealMinesweeper(board, row, column, rows, cols, visited);
        return board;
    }

    private void revealMinesweeper(String[][] board, int row, int col,
                                   int rows, int cols, boolean[][] visited) {
        if (row < 0 || row >= rows || col < 0 || col >= cols
                || visited[row][col]
                || !Objects.equals(board[row][col], "H")) {
            return;
        }
        visited[row][col] = true;

        int nbors = 0;
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                int nr = row + dr, nc = col + dc;
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    nbors += Objects.equals(board[nr][nc], "M") ? 1 : 0;
                }
            }
        }

        board[row][col] = String.valueOf(nbors);
        if (nbors == 0) {
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    revealMinesweeper(board, row + dr, col + dc, rows, cols,
                            visited);
                }
            }
        }
    }
}
