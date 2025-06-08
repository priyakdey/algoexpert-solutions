package com.priyakdey.algoexpersolutions;

/**
 * @author Priyak Dey
 */
public class MinRewards {

    // Two-pass greedy: assign rewards based on increasing order from both sides,
    // then take max of both at each index.
    // Left-to-right handles ascending scores; right-to-left handles descending.
    // Ensure each child gets more than neighbors if score is higher — final reward is max
    // of both buffers.

    public static int minRewards(int[] scores) {
        assert (scores != null && scores.length > 0);

        int length = scores.length;
        int[] leftBuffer = new int[length];
        int[] rightBuffer = new int[length];

        leftBuffer[0] = 1;
        for (int i = 1; i < length; i++) {
            if (scores[i] > scores[i - 1]) {
                leftBuffer[i] = leftBuffer[i - 1] + 1;
            } else {
                leftBuffer[i] = 1;
            }
        }

        rightBuffer[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            if (scores[i] > scores[i + 1]) {
                rightBuffer[i] = rightBuffer[i + 1] + 1;
            } else {
                rightBuffer[i] = 1;
            }
        }

        int rewards = 0;
        for (int i = 0; i < length; i++) {
            rewards += Math.max(leftBuffer[i], rightBuffer[i]);
        }

        return rewards;
    }

}
