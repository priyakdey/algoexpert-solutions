package com.priyakdey;

import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class InsertionSort {

    public static int[] insertionSort(int[] array) {
        Objects.requireNonNull(array);
        int length = array.length;
        if (length <= 1) return array;

        for (int i = 1; i < length; i++) {
            int num = array[i];
            int insertionIndex = findInsertionIndex(array, i - 1, num);
            if (insertionIndex != -1) {
                int l = i - 1 - insertionIndex + 1;
                System.arraycopy(array, insertionIndex, array, insertionIndex + 1, l);
                array[insertionIndex] = num;
            }
        }

        return array;
    }

    private static int findInsertionIndex(int[] array, int right, int target) {
        int left = 0;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= target) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }

}
