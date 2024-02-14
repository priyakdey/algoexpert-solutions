package com.priyakdey;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Priyak Dey
 */
public class LargestRange {

    public static int[] largestRange(int[] array) {
        Objects.requireNonNull(array);
        int length = array.length;
        if (length == 1) return new int[] {array[0], array[0]};

        Set<Integer> distinct = Arrays.stream(array).boxed().collect(Collectors.toSet());

        int[] range = {-1, -1};
        int maxRangeLength = 0;

        for (int num : array) {
            if (distinct.contains(num)) {
                distinct.remove(num);

                int right = num + 1;
                while (distinct.contains(right)) {
                    distinct.remove(right);
                    right++;
                }

                right = right - 1;

                int left = num - 1;
                while (distinct.contains(left)) {
                    distinct.remove(left);
                    left--;
                }

                left = left + 1;

                int rangeLength = right - left + 1;
                if (rangeLength > maxRangeLength) {
                    maxRangeLength = rangeLength;
                    range[0] = left;
                    range[1] = right;
                }
            }
        }

        return range;
    }

}
