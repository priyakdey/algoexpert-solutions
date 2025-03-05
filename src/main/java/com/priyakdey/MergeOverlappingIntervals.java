package com.priyakdey;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Priyak Dey
 */
public class MergeOverlappingIntervals {

    // Sort the intervals and then try and see if they overlap.
    // If currStart <= prevEnd, they overlap else not.

    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        int length = intervals.length;
        Arrays.sort(intervals,
                Comparator.comparing((int[] a) -> a[0]).thenComparingInt(a -> a[1]));

        int[][] temp = new int[length][2];
        temp[0][0] = intervals[0][0];
        temp[0][1] = intervals[0][1];
        int cursor = 0;

        for (int i = 1; i < length; i++) {
            int prevStart = temp[cursor][0];
            int prevEnd = temp[cursor][1];

            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            int start, end;
            if (currStart <= prevEnd) {
                start = prevStart;
                end = Math.max(prevEnd, currEnd);
            } else {
                start = currStart;
                end = currEnd;
                cursor++;
            }

            temp[cursor][0] = start;
            temp[cursor][1] = end;
        }

        int[][] merged = new int[cursor + 1][2];
        for (int i = 0; i <= cursor; i++) {
            merged[i][0] = temp[i][0];
            merged[i][1] = temp[i][1];
        }

        return merged;
    }

}
