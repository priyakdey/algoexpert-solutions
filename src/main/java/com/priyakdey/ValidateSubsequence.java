package com.priyakdey;

import java.util.List;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class ValidateSubsequence {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int arraySize = array.size();
        int sequenceSize = sequence.size();
        int i = 0, j = 0;

        while (i < arraySize && j < sequenceSize) {
            if (Objects.equals(array.get(i), sequence.get(j))) {
                j++;
            }
            i++;
        }

        return j == sequenceSize;
    }

}
