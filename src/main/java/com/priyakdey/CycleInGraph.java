package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class CycleInGraph {

    // DFS from each node if not visited to find cycle.
    // For a directed graph, use a recursion stack to see if during DFS, the
    // node was visited, if visited, it has a cycle.
    // We can also use Kahn's algorithm for topology for determining
    // if cycle exists.

    public boolean cycleInGraph(int[][] edges) {
        int nodes = edges.length;
        int[] indegrees = new int[nodes];

        for (int[] edge : edges) {
            for (int neighbor : edge) {
                indegrees[neighbor]++;
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int visitedNodes = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visitedNodes++;

            for (int neighbor : edges[node]) {
                indegrees[neighbor]--;
                if (indegrees[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return visitedNodes != nodes;
    }

    public boolean cycleInGraph2(int[][] edges) {
        int nodes = edges.length;
        boolean[] visited = new boolean[nodes];
        boolean[] recStack = new boolean[nodes];

        for (int node = 0; node < nodes; node++) {
            if (!visited[node] && hasCycle(node, edges, visited, recStack)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasCycle(int node, int[][] edges, boolean[] visited,
                             boolean[] recStack) {
        if (recStack[node]) return true;
        if (visited[node]) return false;

        visited[node] = true;
        recStack[node] = true;

        for (int nbor : (edges[node])) {
            if (hasCycle(nbor, edges, visited, recStack)) {
                return true;
            }
        }

        recStack[node] = false;
        return false;
    }

}
