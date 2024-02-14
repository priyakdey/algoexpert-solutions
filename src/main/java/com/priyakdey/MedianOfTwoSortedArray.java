package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class MedianOfTwoSortedArray {

    public float medianOfTwoSortedArrays(int[] arrayOne, int[] arrayTwo) {
        int length1 = arrayOne.length;
        int length2 = arrayTwo.length;
        int length = length1 + length2;
        int mid = length / 2;

        int i = 0, j = 0;

        int mid1 = -1;
        int mid2 = -1;

        while (i < length1 && j < length2 && mid >= 0) {
            mid1 = mid2;
            if (arrayOne[i] <= arrayTwo[j]) {
                mid2 = arrayOne[i++];
            } else {
                mid2 = arrayTwo[j++];
            }
            mid--;
        }

        while (i < length1 && mid >= 0) {
            mid1 = mid2;
            mid2 = arrayOne[i++];
            mid--;
        }

        while (j < length2 && mid >= 0) {
            mid1 = mid2;
            mid2 = arrayTwo[j++];
            mid--;
        }

        if (length % 2 == 0) return (mid1 + mid2) / 2.0f;

        return mid2;
    }

}
