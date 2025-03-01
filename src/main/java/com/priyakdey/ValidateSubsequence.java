package com.priyakdey;

import java.util.List;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class ValidateSubsequence {

    // Use two pointers to iterate over both arrays.
    // If elements are same, advance both pointers by 1.
    // If all elements in sequence is iterated, it is a valid
    // subsequence.

    public static boolean isValidSubsequence(List<Integer> array,
                                             List<Integer> sequence) {
        int i = 0, j = 0;

        while (i < array.size() && j < sequence.size()) {
            if (Objects.equals(array.get(i), sequence.get(j))) {
                j++;
            }
            i++;
        }

        return j == sequence.size();
    }

}
