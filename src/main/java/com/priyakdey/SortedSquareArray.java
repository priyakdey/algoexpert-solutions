package com.priyakdey;

import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class SortedSquareArray {

    public int[] sortedSquaredArray(int[] array) {
        Objects.requireNonNull(array);
        int length = array.length;

        int left = 0, right = length - 1;
        int cursor = length - 1;
        int[] squares = new int[length];

        while (cursor >= 0) {
            int a = array[left] * array[left];
            int b = array[right] * array[right];

            if (a >= b) {
                squares[cursor--] = a;
                left++;
            } else {
                squares[cursor--] = b;
                right--;
            }
        }

        return squares;
    }

}
