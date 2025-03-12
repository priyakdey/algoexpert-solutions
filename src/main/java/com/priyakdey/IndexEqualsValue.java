package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class IndexEqualsValue {

    // Use binary search

    public int indexEqualsValue(int[] array) {
        int index = -1;
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == mid) {
                index = mid;
                right = mid - 1;
            } else if (array[mid] > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }

}
