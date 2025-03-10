package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class LongestSubarrayWithSum {

    // Use a hashmap to look back at the cumulative sums we
    // have already calculated. Since all elements are +ve, we won't get
    // duplicate sums, still if we do - that is why putIfAbsent.

    public int[] longestSubarrayWithSum(int[] array, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        int maxLength = 0;
        int left = -1, right = -1;

        for (int i = 0; i < array.length; i++) {
            currSum += array[i];
            int complement = currSum - targetSum;
            if (currSum == targetSum) {
                int length = i - 0 + 1;
                if (length > maxLength) {
                    maxLength = length;
                    left = 0;
                    right = i;
                }
            } else if (map.containsKey(complement)) {
                int j = map.get(complement) + 1;
                int length = i - j + 1;
                if (length > maxLength) {
                    maxLength = length;
                    left = j + 1;
                    right = i;
                }
            }

            map.putIfAbsent(currSum, i);
        }
        return maxLength != 0 ? new int[]{left, right} : new int[]{};
    }

}
