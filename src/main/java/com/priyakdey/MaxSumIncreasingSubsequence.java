package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class MaxSumIncreasingSubsequence {

    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        int[] maxSum = new int[]{Integer.MIN_VALUE};
        List<Integer> result = new ArrayList<>();
        maxSumIncreasingSubsequence(array, 0, 0, maxSum, new ArrayList<>(),
                result);
        return List.of(List.of(maxSum[0]), result);
    }

    public static void maxSumIncreasingSubsequence(int[] array, int index,
                                                   int currSum, int[] maxSum,
                                                   List<Integer> acc,
                                                   List<Integer> result) {
        if (index == array.length) {
            if (currSum > maxSum[0] && !acc.isEmpty()) {
                maxSum[0] = currSum;
                result.clear();
                result.addAll(acc);
            }
            return;
        }

        maxSumIncreasingSubsequence(array, index + 1, currSum, maxSum, acc,
                result);

        if (acc.isEmpty() || array[index] > acc.getLast()) {
            acc.add(array[index]);
            maxSumIncreasingSubsequence(array, index + 1,
                    currSum + array[index], maxSum, acc, result);
            acc.removeLast();
        }
    }
}
