package com.priyakdey.algoexpersolutions;

/**
 * @author Priyak Dey
 */
public class SubarraySort {

    // Scan left-to-right and right-to-left to detect the unsorted window — mark boundaries where
    // order breaks relative to current max/min.
    // Right boundary: from left, update currMax; any drop marks potential end.
    // Left boundary: from right, update currMin; any rise marks potential start of the subarray
    // that needs sorting.

    public static int[] subarraySort(int[] array) {
        int length = array.length;
        int leftIndex = -1, rightIndex = -1;

        int currMax = array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] >= currMax) {
                currMax = array[i];
            } else {
                rightIndex = i;
            }
        }

        int currMin = array[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            if (array[i] <= currMin) {
                currMin = array[i];
            } else {
                leftIndex = i;
            }
        }

        return new int[]{leftIndex, rightIndex};
    }

}
