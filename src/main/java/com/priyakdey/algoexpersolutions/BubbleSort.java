package com.priyakdey.algoexpersolutions;

/**
 * @author Priyak Dey
 */
public class BubbleSort {

    // Classic bubble sort — repeatedly swap adjacent elements if out of order, shrinking
    // range with each outer loop

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int x = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = x;
                }
            }
        }

        return array;
    }
}
