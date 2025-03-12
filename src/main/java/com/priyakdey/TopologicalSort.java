package com.priyakdey;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class TopologicalSort {

    // Iterate over the dependency list - edges and generate the adjList and
    // indegrees list. Indegree = number of incoming edges into the node.
    // Push every node with indegree 0 into the queue.
    // Poll from queue, increment a counter and then iterate overall dependent
    // jobs decreasing the indegrees for them by 1. If for any node, the
    // indegree is 0, push them into the queue.
    // If at end counter == total nodes -> we can have an order, else not.

    public static List<Integer> topologicalSort(List<Integer> jobs,
                                                List<Integer[]> deps) {
        int size = jobs.size();
        List<Integer> order = new ArrayList<>(size);

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();

        for (Integer[] dep : deps) {
            int prerequisite = dep[0];
            int dependent = dep[1];
            if (!graph.containsKey(prerequisite)) {
                graph.put(prerequisite, new ArrayList<>());
            }
            graph.get(prerequisite).add(dependent);
            inDegrees.compute(dependent, (k, v) -> v == null ? 1 : v + 1);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int job : jobs) {
            if (!inDegrees.containsKey(job)) {
                queue.offer(job);
            }
        }

        int completed = 0;
        while (!queue.isEmpty()) {
            int job = queue.poll();
            completed++;
            order.add(job);

            if (!graph.containsKey(job)) {
                continue;
            }

            for (int dependentJob : graph.get(job)) {
                inDegrees.computeIfPresent(dependentJob, (k, v) -> v - 1);
                if (inDegrees.get(dependentJob) == 0) {
                    queue.offer(dependentJob);
                }
            }
        }

        return completed == jobs.size() ? order : new ArrayList<>();
    }

}
