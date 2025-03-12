package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ShiftedBinarySearch {

    // Use binary search

    public static int shiftedBinarySearch(int[] array, int target) {
        int length = array.length;
        int left = 0, right = length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                index = mid;
                break;
            }

            if (array[mid] < array[length - 1]) {
                if (target < array[mid]) {
                    right = mid - 1;
                } else {
                    if (target <= array[length - 1]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            } else {
                if (target > array[mid]) {
                    left = mid + 1;
                } else {
                    if (target <= array[length - 1]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }

        return index;
    }

}
