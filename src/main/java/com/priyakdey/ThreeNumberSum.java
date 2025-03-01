package com.priyakdey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class ThreeNumberSum {

    // Sort the array and use two pointers to find the three sum.
    // For duplicates, check with previous number for the pointers.

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> triplets = new ArrayList<>();

        Arrays.sort(array);

        for (int i = 0; i < array.length - 2; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }

            int x = array[i];
            int j = i + 1, k = array.length - 1;
            while (j < k) {
                if (j > i + 1 && array[j] == array[j - 1]) {
                    j++;
                }

                int y = array[j], z = array[k];
                int sum = x + y + z;
                if (sum == targetSum) {
                    triplets.add(new Integer[]{x, y, z});
                    j++;
                    k--;
                } else if (sum > targetSum) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return triplets;
    }

}
