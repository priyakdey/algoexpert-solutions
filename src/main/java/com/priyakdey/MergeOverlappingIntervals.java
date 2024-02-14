package com.priyakdey;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Priyak Dey
 */
public class MergeOverlappingIntervals {

    public int[][] mergeOverlappingIntervals(int[][] intervals) {

        Arrays.sort(intervals,
            Comparator.comparing((int[] arr) -> arr[0]).thenComparing(arr -> arr[1]));

        int length = intervals.length;
        int[][] mergedIntervals = new int[length][2];
        mergedIntervals[0] = intervals[0];

        int cursor = 0;

        for (int i = 1; i < length; i++) {
            int startTime, endTime;

            int prevStartTime = mergedIntervals[cursor][0];
            int prevEndTime   = mergedIntervals[cursor][1];

            int currStartTime = intervals[i][0];
            int currEndTime   = intervals[i][1];

            if (currStartTime == prevStartTime || currStartTime <= prevEndTime) {
                startTime = prevStartTime;
                endTime = Math.max(prevEndTime, currEndTime);
            } else {
                startTime = currStartTime;
                endTime = currEndTime;
                cursor++;
            }

            mergedIntervals[cursor][0] = startTime;
            mergedIntervals[cursor][1] = endTime;
        }

        int[][] arr = new int[cursor + 1][2];
        System.arraycopy(mergedIntervals, 0, arr, 0, cursor + 1);
        return arr;
    }


}
