package com.priyakdey;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class MinRewards {

    // Go from left to right and increment prize if current
    // element > prev element.
    // Do the same for right to left.
    // Find the max in both the traversals to find the actual
    // reward for that student.

    public static int minRewards(int[] scores) {
        int length = scores.length;
        int[] rewards1 = new int[length];
        Arrays.fill(rewards1, 1);
        int[] rewards2 = new int[length];
        Arrays.fill(rewards2, 1);

        for (int i = 1; i < length; i++) {
            if (scores[i] > scores[i - 1]) {
                rewards1[i] = rewards1[i - 1] + 1;
            }
        }

        for (int i = length - 2; i >= 0; i--) {
            if (scores[i] > scores[i + 1]) {
                rewards2[i] = rewards2[i + 1] + 1;
            }
        }

        int totalRewards = 0;
        for (int i = 0; i < length; i++) {
            totalRewards += Math.max(rewards1[i], rewards2[i]);
        }

        return totalRewards;
    }

}
