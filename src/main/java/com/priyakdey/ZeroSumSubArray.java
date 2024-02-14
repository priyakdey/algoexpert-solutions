package com.priyakdey;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class ZeroSumSubArray {

    public boolean zeroSumSubarray(int[] nums) {
        int length = nums.length;
        if (length == 0) return false;
        if (length == 1) return nums[0] == 0;
        if (length == 2) return nums[0] == 0 || nums[1] == 0 || nums[0] + nums[1] == 0;


        Set<Integer> runningSum = new HashSet<>();
        int sum = 0;
        for (int num : nums) {
            if (num == 0) return true;

            sum += num;
            if (runningSum.contains(sum)) return true;
            runningSum.add(sum);
        }

        return false;
    }

}
