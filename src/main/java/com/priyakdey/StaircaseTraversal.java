package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class StaircaseTraversal {

    public int staircaseTraversal(int height, int maxSteps) {
        if (maxSteps <= 0 || maxSteps > height) {
            throw new IllegalArgumentException("invalid input");
        }

        // return staircaseTraversal(0, maxSteps, height, new Integer[height + 1]);
        return staircaseTraversalTabulation(height, maxSteps);
    }

    private int staircaseTraversalTabulation(int height, int maxSteps) {
        int[] cache = new int[height + 1];

        cache[0] = 1;

        for (int currHeight = 1; currHeight <= height; currHeight++) {
            int ways = 0;
            for (int step = 1; step <= maxSteps; step++) {
                if (currHeight - step >= 0) {
                    ways += cache[currHeight - step];
                }
                cache[currHeight] = ways;
            }
        }

        return cache[height];
    }

    private int staircaseTraversal(int currHeight, int maxSteps, int height, Integer[] cache) {
        if (currHeight == height) return 1;

        if (cache[currHeight] != null) return cache[currHeight];

        int ways = 0;

        for (int step = 1; step <= maxSteps; step++) {
            if (currHeight + step <= height) {
                ways += staircaseTraversal(currHeight + step, maxSteps, height, cache);
            }
        }

        cache[currHeight] = ways;
        return ways;
    }

}
