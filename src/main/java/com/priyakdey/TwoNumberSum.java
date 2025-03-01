package com.priyakdey;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class TwoNumberSum {

    // Use a hashmap for a quick lookup on already seen elements

    public static int[] twoNumberSum(int[] array, int targetSum) {
        Set<Integer> seen = new HashSet<>();
        for (int num : array) {
            int compliment = targetSum - num;
            if (seen.contains(compliment)) {
                return new int[]{compliment, num};
            }

            seen.add(num);
        }

        return new int[]{};
    }

}
