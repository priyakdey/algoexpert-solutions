package com.priyakdey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class FourNumberSum {

    // Extension of three sum problem. Sort the array and
    // use O(n^3) solution.

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        int length = array.length;
        List<Integer[]> quads = new ArrayList<>();

        Arrays.sort(array);

        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && array[j] == array[j - 1]) {
                    continue;
                }

                int a = array[i], b = array[j];
                int left = j + 1, right = length - 1;
                while (left < right) {
                    if (left > j + 1 && array[left] == array[left - 1]) {
                        left++;
                        continue;
                    }
                    int c = array[left], d = array[right];
                    int sum = a + b + c + d;
                    if (sum == targetSum) {
                        quads.add(new Integer[]{a, b, c, d});
                        left++;
                        right--;
                    } else if (sum > targetSum) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return quads;
    }

}
