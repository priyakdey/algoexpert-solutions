package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class FirsDuplicateValue {

    // Since values can be b/w 1-n, and length = n,
    // we can use the indices to store and find the information
    // if any number was previously visited by negating the values in the
    // index.

    public int firstDuplicateValue(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int value = Math.abs(array[i]);
            int index = value - 1;
            if ((array[index] < 0)) {
                return value;
            }
            array[index] *= -1;
        }

        return -1;
    }

}
