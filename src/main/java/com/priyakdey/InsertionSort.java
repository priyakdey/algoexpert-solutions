package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class InsertionSort {

    // https://www.programiz.com/dsa/insertion-sort

    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
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
