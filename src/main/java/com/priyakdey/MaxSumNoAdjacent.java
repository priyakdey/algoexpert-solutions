package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class MaxSumNoAdjacent {

    // House robber problem

    public static int maxSubsetSumNoAdjacent(int[] array) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return array[0];
        }

        int adjMaxSum = array[length - 2];
        int nonAdjMaxSum = array[length - 1];

        for (int i = length - 3; i >= 0; i--) {
            int currSum = array[i] + nonAdjMaxSum;
            nonAdjMaxSum = Math.max(adjMaxSum, nonAdjMaxSum);
            adjMaxSum = currSum;
        }

        return Math.max(adjMaxSum, nonAdjMaxSum);
    }

}
