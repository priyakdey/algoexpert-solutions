package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class SortedAquareArray {

    // Take two pointers - left and right. Start filling in the results
    // in the result array from the back.

    public int[] sortedSquaredArray(int[] array) {
        int length = array.length;
        int left = 0, right = length - 1;
        int cursor = length - 1;
        int[] squaredArray = new int[length];

        while (cursor >= 0) {
            int x = array[left] * array[left];
            int y = array[right] * array[right];

            if (y >= x) {
                squaredArray[cursor--] = y;
                right--;
            } else {
                squaredArray[cursor--] = x;
                left++;
            }
        }

        return squaredArray;
    }

}
