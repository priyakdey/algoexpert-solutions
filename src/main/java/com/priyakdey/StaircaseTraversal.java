package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class StaircaseTraversal {

    // General dp solution. Every recursion, try going from 1...steps,
    // and remove those many steps from height.

    public int staircaseTraversal(int height, int maxSteps) {
        int[] cache = new int[height + 1];

        cache[height] = 1;

        for (int i = height - 1; i >= 0; i--) {
            int ways = 0;
            for (int steps = 1; steps <= maxSteps; steps++) {
                if (i + steps <= height) {
                    ways += cache[i + steps];
                }
            }
            cache[i] = ways;
        }

        return cache[0];

        // Integer[] cache = new Integer[height + 1];
        // return staircaseTraversalRec(height, maxSteps, cache);
    }

    private int staircaseTraversalRec(int height, int maxSteps, Integer[] cache) {
        if (height == 0) {
            return 1;
        }

        if (height < 0) {
            return 0;
        }

        if (cache[height] != null) {
            return cache[height];
        }

        int ways = 0;
        for (int steps = 1; steps <= maxSteps; steps++) {
            ways += staircaseTraversalRec(height - steps, maxSteps, cache);
        }

        cache[height] = ways;
        return ways;
    }

}
