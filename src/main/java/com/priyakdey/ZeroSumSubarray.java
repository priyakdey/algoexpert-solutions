package com.priyakdey;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class ZeroSumSubarray {

    // Find running sum, and keep a track of seen sums.
    // If we see the same sum again, means we can do zero-sum for a subarray

    public boolean zeroSumSubarray(int[] nums) {
        Set<Integer> distinctSum = new HashSet<>();
        distinctSum.add(0);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum == 0 || num == 0) {
                return true;
            }
            if (distinctSum.contains(sum)) {
                return true;
            }
            distinctSum.add(sum);
        }

        return false;
    }

}
