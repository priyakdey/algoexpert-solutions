package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class SelectionSort {

    // select the minimum element in the range and swap with the
    // first index in the range.
    // https://www.programiz.com/dsa/selection-sort

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minElement = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < minElement) {
                    minElement = array[j];
                    minIndex = j;
                }
            }

            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

        return array;
    }

}
