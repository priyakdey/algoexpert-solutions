package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class SubarraySort {

    // Go from left->right and everytime you find an element,
    // which is not greater than max element till now, this is the rightmost
    // index with some issue.
    // Do it for right->left and then find the leftmost index with same issue.

    public static int[] subarraySort(int[] array) {
        int length = array.length;
        int rightIndex = -1;
        int maxElement = array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] < maxElement) {
                rightIndex = i;
            } else {
                maxElement = array[i];
            }
        }

        int leftIndex = -1;
        int minElement = array[length - 1];
        for (int i = length - 1; i >= 0; i--) {
            if (array[i] > minElement) {
                leftIndex = i;
            } else {
                minElement = array[i];
            }
        }

        return new int[]{leftIndex, rightIndex};
    }

}
