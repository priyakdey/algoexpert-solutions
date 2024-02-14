package com.priyakdey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class ThreeNumberSum {

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Objects.requireNonNull(array);
        int length = array.length;
        if (length < 3) return List.of();
        Arrays.sort(array);

        List<Integer[]> triplets = new ArrayList<>();

        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && array[i] == array[i - 1]) continue;
            triplets.addAll(twoNumberSum(array, i + 1, targetSum, array[i]));
        }

        return triplets;
    }

    private static List<Integer[]> twoNumberSum(int[] array, int start, int targetSum, int firstNum) {
        List<Integer[]> triplets = new ArrayList<>();
        int end = array.length - 1;

        while (start < end) {
            int secondNum = array[start];
            int thirdNum = array[end];
            int sum = firstNum + secondNum + thirdNum;

            if (sum == targetSum) {
                triplets.add(new Integer[] {firstNum, secondNum, thirdNum});
                start++;
                end--;
            } else if (sum > targetSum) {
                end--;
            } else {
                start++;
            }
        }

        return triplets;
    }

}
