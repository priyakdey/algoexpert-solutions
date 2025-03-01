package com.priyakdey;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class SmallestDifference {

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int i = 0, j = 0;
        int minDiff = Integer.MAX_VALUE;
        int[] pair = new int[2];

        while (i < arrayOne.length && j < arrayTwo.length) {
            int x = arrayOne[i], y = arrayTwo[j];
            int diff = Math.abs(x - y);

            if (diff < minDiff) {
                minDiff = diff;
                pair[0] = x;
                pair[1] = y;
            }

            if (x <= y) {
                i++;
            } else {
                j++;
            }
        }

        return pair;
    }

}
