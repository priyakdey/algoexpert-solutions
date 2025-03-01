package com.priyakdey;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class MinWaitingTime {

    // Sort the array in asc order and find the prefix cumulative sum for each.

    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int totalWaitingTime = 0;
        int prefixSum = 0;

        for (int i = 1; i < queries.length; i++) {
            prefixSum += queries[i - 1];
            totalWaitingTime += prefixSum;
        }

        return totalWaitingTime;
    }


}
