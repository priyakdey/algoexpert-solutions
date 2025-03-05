package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class KadanesAlgorithm {

    // At any given index, the max of that subarray ending at that index
    // is either previous max + num or num.

    public static int kadanesAlgorithm(int[] array) {
        int overallMax = array[0];
        int currentMax = array[0];

        for (int i = 1; i < array.length; i++) {
            int num = array[i];
            currentMax = Math.max(currentMax + num, num);
            overallMax = Math.max(overallMax, currentMax);
        }

        return overallMax;
    }

}
