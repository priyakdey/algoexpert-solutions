package com.priyakdey.algoexpersolutions;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class LargestRange {

    // Use a set to expand left/right from each number and greedily find the longest contiguous
    // range without sorting.
    // Remove numbers from the set as you process to avoid rework.
    // Track the max range and update [start, end] accordingly — ensures O(n) time overall.

    public static int[] largestRange(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            set.add(num);
        }

        int[] result = {-1, -1};
        int maxRange = 0;

        for (int num : array) {
            if (!set.contains(num)) continue;

            set.remove(num);

            int left = num - 1;
            while (set.contains(left)) {
                set.remove(left);
                left--;
            }

            int right = num + 1;
            while (set.contains(right)) {
                set.remove(right);
                right++;
            }

            int x = left + 1;
            int y = right - 1;
            int range = y - x + 1;
            if (range > maxRange) {
                maxRange = range;
                result[0] = x;
                result[1] = right - 1;
            }
        }

        return result;
    }

}
