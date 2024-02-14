package com.priyakdey;

import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class IndexEqualsValue {

    public int indexEqualsValue(int[] array) {
        Objects.requireNonNull(array);
        int length = array.length;

        int left = 0, right = length - 1;
        int index = -1;

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
