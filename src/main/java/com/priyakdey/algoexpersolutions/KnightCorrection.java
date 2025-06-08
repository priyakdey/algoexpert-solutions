package com.priyakdey.algoexpersolutions;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class KnightCorrection {

    // Use BFS to find the shortest path between two knights on an infinite chessboard, then round
    // up the move count with (d >> 1) + (d & 1).
    //
    // Each knight move expands 8 directions; distance tracks number of moves taken.
    // Final distance is adjusted to reflect the number of actual knight connections,
    // likely implying 2-move pairings.

    public int knightConnection(int[] knightA, int[] knightB) {
        Deque<Cell> queue = new ArrayDeque<>();
        Set<Cell> visited = new HashSet<>();
        Cell src = new Cell(knightA[1], knightA[0], 0);
        Cell dest = new Cell(knightB[1], knightB[0], 0);

        int[][] directions = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

        queue.offer(src);
        visited.add(src);

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            int distance = cell.distance;

            if (Objects.equals(cell, dest)) {
                return (distance >> 1) + (distance & 1);
            }

            for (int[] direction : directions) {
                int dy = direction[1];
                int dx = direction[0];
                Cell next = cell.next(dy, dx);
                if (!visited.contains(next)) {
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }

        return -1;
    }

    private record Cell(int y, int x, int distance) {

        Cell next(int dy, int dx) {
            return new Cell(y + dy, x + dx, distance + 1);
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return y == cell.y && x == cell.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }

}
