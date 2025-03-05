package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ThreeNumberSort {

    // Dutch Flag Sorting Algorithm.
    // Have two pointers on the extreme and one iterator.
    // Depending on condition, swap and move the pointers.

    public int[] threeNumberSort(int[] array, int[] order) {
        int x = order[0], y = order[1], z = order[2];
        int left = 0, mid = 0, right = array.length - 1;

        while (mid <= right) {
            if (array[mid] == x) {
                swap(array, left, mid);
                mid++;
                left++;
            } else if (array[mid] == y) {
                mid++;
            } else {
                swap(array, mid, right);
                right--;
            }
        }

        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
