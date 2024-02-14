package com.priyakdey;

import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class SelectionSort {

    public static int[] selectionSort(int[] array) {
        Objects.requireNonNull(array);
        int length = array.length;
        if (length <= 1) return array;

        for (int i = 0; i < length; i++) {
            int min = array[i];
            int swapIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    swapIndex = j;
                }
            }

            array[swapIndex] = array[i];
            array[i] = min;
        }

        return array;
    }

}
