package com.priyakdey;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class TwoNumberSum {

    public static int[] twoNumberSum(int[] array, int targetSum) {
        Set<Integer> visited = new HashSet<>();
        for (int num : array) {
            int compliment = targetSum - num;
            if (visited.contains(compliment)) {
                return new int[] {compliment, num};
            }
            visited.add(num);
        }

        return new int[] {};
    }

}
