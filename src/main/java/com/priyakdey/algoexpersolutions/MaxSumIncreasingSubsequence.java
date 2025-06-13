package com.priyakdey.algoexpersolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class MaxSumIncreasingSubsequence {

    // Classic DP for Max Sum Increasing Subsequence (MSIS) — for each index, track the best sum
    // you can build starting from that number, along with a pointer to the next index.
    //
    // From right to left, for every element, look ahead to find valid array[j] > array[i] that
    // gives the max sum — update current sum accordingly.
    // Track the nextIndex in each DP cell to reconstruct the sequence later.

    // TODO: Optimize to O(n log n) using Patience Sorting + Binary Search
    // Idea: Maintain a list of increasing sequences, use binary search to find insert positions
    // and backtrack to reconstruct the sequence and max sum.

    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        assert (array != null && array.length > 0);

        int length = array.length;
        if (length == 1) return List.of(List.of(array[0]), List.of(array[0]));

        Pair[] pairs = new Pair[length];
        pairs[length - 1] = new Pair(array[length - 1], -1);

        for (int i = length - 2; i >= 0; i--) {
            int value = array[i];

            int nextIndex = -1;
            int nextMaxSum = Integer.MIN_VALUE;

            for (int j = i + 1; j < length; j++) {
                // consider the pair for which current value is strictly less, and the can
                // generate the max sum in the sequence
                if (array[j] > value && pairs[j].maxSumAt > nextMaxSum) {
                    nextMaxSum = pairs[j].maxSumAt;
                    nextIndex = j;
                }
            }

            if (nextIndex == -1) {
                pairs[i] = new Pair(value, -1);
            } else {
                pairs[i] = new Pair(value + nextMaxSum, nextIndex);
            }
        }

        int maxSeqSum = pairs[0].maxSumAt;
        int index = 0;

        for (int i = 1; i < length; i++) {
            if (pairs[i].maxSumAt > maxSeqSum) {
                maxSeqSum = pairs[i].maxSumAt;
                index = i;
            }
        }

        List<Integer> sequence = new ArrayList<>();
        while (pairs[index].nextIndex != -1) {
            sequence.add(array[index]);
            index = pairs[index].nextIndex;
        }

        sequence.add(array[index]);

        return List.of(List.of(maxSeqSum), sequence);
    }


    private record Pair(int maxSumAt, int nextIndex) {
    }

}
