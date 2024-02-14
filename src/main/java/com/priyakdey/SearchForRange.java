package com.priyakdey;

import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class SearchForRange {

    public static int[] searchForRange(int[] array, int target) {
        Objects.requireNonNull(array);
        int length = array.length;

        int startIndex = findStartIndexOfEqOrGt(array, target);

        if (startIndex == -1 || array[startIndex] != target) {
            // all elements are smaller than 45, so not found.
            // or, we found target + 1, so not found.
            return new int[] {-1, -1};
        }

        int lastIndex = findStartIndexOfEqOrGt(array, target + 1);
        if (lastIndex == -1) {
            // no elements greater than target present
            return new int[] {startIndex, length - 1};
        }

        return new int[] {startIndex, lastIndex - 1};
    }

    private static int findStartIndexOfEqOrGt(int[] array, int element) {
        int left = 0, right = array.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= element) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }

}
