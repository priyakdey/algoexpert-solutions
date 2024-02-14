package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class SubarraySort {

    public static int[] subarraySort(int[] array) {
        if (array == null || array.length <= 1) {
            throw new IllegalArgumentException("invalid input");
        }

        int length = array.length;
        int rightMostIndex = -1;
        int max = array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] >= max) {
                max = array[i];
            } else {
                rightMostIndex = i;
            }
        }

        int leftMostIndex = -1;
        int min = array[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            if (array[i] <= min) {
                min = array[i];
            } else {
                leftMostIndex = i;
            }
        }

        return new int[] { leftMostIndex, rightMostIndex};
    }

}
