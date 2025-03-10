package com.priyakdey;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Priyak Dey
 */
public class LargestRange {

    // Push all elements in the set. Iterate over the array and if element
    // present
    // in the array = process it. Go right and left from the number and use the
    // set to see if the number existed in the array, set gives fast lookup.
    // This way we can find the max range in the array.

    public static int[] largestRange(int[] array) {
        int left = -1, right = -1;
        int maxLength = 0;

        Set<Integer> notVisited =
                Arrays.stream(array).boxed().collect(Collectors.toSet());

        for (int num : array) {
            if (!notVisited.contains(num)) {
                continue;
            }

            int l = num, r = num + 1;
            while (notVisited.contains(l)) {
                notVisited.remove(l);
                l--;
            }

            while (notVisited.contains(r)) {
                notVisited.remove(r);
                r++;
            }

            int range = (r - 1) - (l + 1) + 1;
            if (range > maxLength) {
                maxLength = range;
                left = l + 1;
                right = r - 1;
            }
        }

        return new int[]{left, right};
    }

}
