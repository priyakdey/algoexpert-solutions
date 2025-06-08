package com.priyakdey.algoexpersolutions;

/**
 * @author Priyak Dey
 */
public class BinarySearch {

    // The most simplest straight forward binary search operation.

    public static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == array[mid]) {
                index = mid;
                break;
            } else if (target < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }

}
