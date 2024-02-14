package com.priyakdey;

import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class CountInversion {

    public int countInversions(int[] array) {
        Objects.requireNonNull(array);
        int length = array.length;
        if (length <= 1) return 0;

        return sort(array, 0, length - 1);
    }

    private int sort(int[] array, int left, int right) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;
        return sort(array, left, mid)
            + sort(array, mid + 1, right)
            + merge(array, left, mid, mid + 1, right);
    }

    private int merge(int[] array, int leftFrom, int leftTo, int rightFrom, int rightTo) {
        int length = rightTo - leftFrom + 1;
        int[] mergedArr = new int[length];

        int i = leftFrom, j = rightFrom;
        int cursor = 0;
        int inversionCount = 0;

        while (i <= leftTo && j <= rightTo) {
            if (array[i] <= array[j]) {
                mergedArr[cursor++] = array[i++];
            } else {
                mergedArr[cursor++] = array[j++];

                // count inversions
                inversionCount += leftTo - i + 1;
            }
        }

        while (i <= leftTo) {
            mergedArr[cursor++] = array[i++];
        }

        while (j <= rightTo) {
            mergedArr[cursor++] = array[j++];
        }

        System.arraycopy(mergedArr, 0, array, leftFrom, length);
        return inversionCount;
    }

}
