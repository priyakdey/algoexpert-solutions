package com.priyakdey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class FourNumberSum {

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);

        List<Integer[]> quadruplets = new ArrayList<>();

        int length = array.length;
        for (int i = 0; i <= length - 4; i++) {
            for (int j = i + 1; j <= length - 3; j++) {
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = array[i] + array[j] + array[left] + array[right];
                    if (sum == targetSum) {
                        quadruplets.add(
                            new Integer[] {array[i], array[j], array[left], array[right]});
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

        return quadruplets;
    }

}
