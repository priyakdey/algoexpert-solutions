package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class MissingNumbers {

    // The function uses the properties of the array to mark the presence
    // of number by negating the values at corresponding indices.
    // It then identifies the missing numbers by checking which
    // indices have positive values.

    public int[] missingNumbers(int[] nums) {
        int length = nums.length;
        int n = length + 2;

        boolean aMissing = true, bMissing = true;

        for (int i = 0; i < length; i++) {
            int value = Math.abs(nums[i]);
            if (value > length) {
                if (value == (length + 1)) {
                    aMissing = false;
                } else {
                    bMissing = false;
                }
                continue;
            }

            int index = value - 1;
            nums[index] *= -1;
        }

        int[] missingNumbers = new int[2];

        int j = 1;
        if (bMissing) {
            missingNumbers[j--] = n;
        }
        if (aMissing) {
            missingNumbers[j--] = n - 1;
        }

        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] > 0) {
                missingNumbers[j--] = i + 1;
            }
        }

        return missingNumbers;
    }

}
