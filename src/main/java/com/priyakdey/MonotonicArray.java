package com.priyakdey;

import java.util.function.BiPredicate;

/**
 * @author Priyak Dey
 */
public class MonotonicArray {

    // Find the first index where curr != prev.
    // Figure out the predicate - non-increasing or non-decreasing.
    // Make sure for all elements, this predicate is true.

    public static boolean isMonotonic(int[] array) {
        assert array != null;
        int length = array.length;
        if (length < 2) {
            return true;
        }

        int i = 1;
        while (i < length && array[i] == array[i - 1]) {
            i++;
        }

        if (i == length) {
            return true;
        }

        BiPredicate<Integer, Integer> nonDecreasing =
                (prev, curr) -> prev <= curr;
        BiPredicate<Integer, Integer> nonIncreasing =
                (prev, curr) -> prev >= curr;

        BiPredicate<Integer, Integer> predicate = nonDecreasing;
        if (array[i - 1] > array[i]) {
            predicate = nonIncreasing;
        }

        while (i < length) {
            if (!predicate.test(array[i - 1], array[i])) {
                return false;
            }
            i++;
        }

        return true;
    }
}
