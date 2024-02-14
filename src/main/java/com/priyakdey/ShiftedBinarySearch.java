package com.priyakdey;

import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class ShiftedBinarySearch {

    public static int shiftedBinarySearch(int[] array, int target) {
        Objects.requireNonNull(array);
        int length = array.length;
        if (length == 0) return -1;
        if (length == 1) return array[0] == target ? 0 : -1;
        if (length == 2) return array[0] == target ? 0 : array[1] == target ? 1 : -1;

        int left = 0, right = length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == array[mid]) {
                index = mid;
                break;
            }

            if (array[mid] <= array[length -1]) {
                if (target > array[mid]) {
                    if (target <= array[length - 1]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    right = mid - 1;
                }
            } else {
                if (target > array[mid]) {
                    left = mid + 1;
                } else {
                    if (target >= array[0]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }

        return index;
    }

}
