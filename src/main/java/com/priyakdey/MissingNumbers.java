package com.priyakdey;

import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class MissingNumbers {

    public int[] missingNumbers(int[] nums) {
        Objects.requireNonNull(nums);
        int length = nums.length;
        int n = length + 2;

        int totalSum = (n * (n + 1)) / 2;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += Math.abs(nums[i]);
            int index = Math.abs(nums[i]) - 1;
            if (index < length) {
                nums[index] = -nums[index];
            }
        }

        int sumOfMissingNumbers = totalSum - sum;

        int firstMissingNumber = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                firstMissingNumber = i + 1;
                break;
            }
        }

        if (firstMissingNumber != 0) {
            return new int[] {firstMissingNumber, sumOfMissingNumbers - firstMissingNumber};
        }

        return new int[] {n - 1, n};
    }
}