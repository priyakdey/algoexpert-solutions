package com.priyakdey;

import java.util.Objects;
import java.util.function.BiPredicate;

/**
 * @author Priyak Dey
 */
public class MonotonicArray {

    public static boolean isMonotonic(int[] array) {
        Objects.requireNonNull(array);
        int length = array.length;
        if (length <= 2) return true;

        int curr = 0;
        while (curr < length - 1 && array[curr] == array[curr + 1]) {
            curr++;
        }

        if (curr == length - 1) return true;

        BiPredicate<Integer, Integer> predicate = (a, b) -> a <= b;     // non-decreasing
        if (array[curr] > array[curr + 1]) {
            predicate = (a, b) -> a >= b;       // non-increasing
        }

        while (curr < length - 1 && predicate.test(array[curr], array[curr + 1])) {
            curr++;
        }

        return curr == length - 1;
    }

}
