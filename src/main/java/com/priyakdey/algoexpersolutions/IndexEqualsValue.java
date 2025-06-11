package com.priyakdey.algoexpersolutions;

/**
 * @author Priyak Dey
 */
public class IndexEqualsValue {

    // Binary search for the first index where array[i] == i; continue search on left to
    // find smallest such match.
    //
    // If array[mid] == mid, store mid and move right to find earlier match.
    // If array[mid] < mid, search right half; else, search left half — standard binary
    // search twist.

    public int indexEqualsValue(int[] array) {
        int index = -1;
        int left = 0, right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == mid) {
                index = mid;
                right = mid - 1;
            } else if (array[mid] < mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }

}
