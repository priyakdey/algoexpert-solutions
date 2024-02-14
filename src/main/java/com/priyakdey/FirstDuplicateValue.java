package com.priyakdey;

import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class FirstDuplicateValue {

    public int firstDuplicateValue(int[] array) {
        Objects.requireNonNull(array);

        int length = array.length;
        if (length <= 1) return -1;
        if (length == 2) return array[0] == array[1] ? array[0] : -1;

        for (int i = 0; i < length; i++) {
            int value = Math.abs(array[i]);
            int index = value - 1;
            if (array[index] < 0) {
                return value;
            }
            array[index] = -array[index];
        }

        return -1;
    }

}
