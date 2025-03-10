package com.priyakdey;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class KnightTraversal {

    // Treat each cell as a node and jumps as the edge.
    // Rotten orange problem !

    public int knightConnection(int[] knightA, int[] knightB) {
        if (knightA[0] == knightB[0] && knightA[1] == knightB[1]) return 0;

        Cell srcCell = new Cell(knightA[0], knightA[1], 0);
        Cell destCell = new Cell(knightB[0], knightB[1], 0);

        int[][] directions = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1},
                {1, -2}, {-1, -2}, {-2, -1}};

        Deque<Cell> queue = new ArrayDeque<>();
        Set<Cell> visited = new HashSet<>();
        queue.offer(srcCell);
        visited.add(srcCell);
        int rounds = -1;
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            if (cell.equals(destCell)) {
                rounds = cell.round;
                break;
            }

            for (int[] direction : directions) {
                int x = cell.x + direction[0];
                int y = cell.y + direction[1];
                Cell nextCell = new Cell(x, y, cell.round + 1);
                if (!visited.contains(nextCell)) {
                    queue.offer(nextCell);
                    visited.add(nextCell);
                }
            }
        }

        assert (rounds != -1);
        return (rounds & 1) == 0 ? rounds / 2 : (rounds / 2) + 1;
    }

    private record Cell(int x, int y, int round) {

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return x == cell.x && y == cell.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
