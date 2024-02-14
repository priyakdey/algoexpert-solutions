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

        int length1 = arrayOne.length;
        int length2 = arrayTwo.length;

        int minDiff = arrayTwo[length2 - 1] - arrayOne[0];
        int[] result = new int[] {arrayTwo[length2 - 1], arrayOne[0]};

        while (i < length1 && j < length2) {
            int diff = Math.abs(arrayOne[i] - arrayTwo[j]);
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = arrayOne[i];
                result[1] = arrayTwo[j];
            }

            if (arrayOne[i] <= arrayTwo[j]) {
                i++;
            } else {
                j++;
            }
        }

        return result;
    }

}
