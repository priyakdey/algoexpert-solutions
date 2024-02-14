package com.priyakdey;

import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] array) {
        Objects.requireNonNull(array);
        int length = array.length;
        if (length <= 1) return array;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }

}
