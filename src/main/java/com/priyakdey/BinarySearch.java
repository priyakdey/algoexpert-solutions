package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class BinarySearch {

    // textbook binary search

    public static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                index = mid;
                break;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }

}
