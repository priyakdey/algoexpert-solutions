package com.priyakdey;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class TandemBicycle {

    // Sort both arrays.
    // For max, we always take one fast + one slow driver.
    // So move one pointer from end of arr1 and another from end of arr2.
    // Whichever is max, take that.
    // For min, start taking from one end, pair each bikers acc to sorting
    // order.

    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds,
                             boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        return fastest
                ? findFastestSpeed(redShirtSpeeds, blueShirtSpeeds)
                : findSlowestSpeed(redShirtSpeeds, blueShirtSpeeds);
    }

    private int findSlowestSpeed(int[] redShirtSpeeds, int[] blueShirtSpeeds) {
        int totalSpeed = 0;

        for (int i = 0; i < redShirtSpeeds.length; i++) {
            totalSpeed += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
        }

        return totalSpeed;
    }

    private int findFastestSpeed(int[] redShirtSpeeds, int[] blueShirtSpeeds) {
        int length = redShirtSpeeds.length;
        int i = length - 1, j = length - 1;

        int totalSpeed = 0;
        while (length > 0) {
            if (redShirtSpeeds[i] >= blueShirtSpeeds[j]) {
                totalSpeed += redShirtSpeeds[i];
                i -= 1;
            } else {
                totalSpeed += blueShirtSpeeds[j];
                j -= 1;
            }

            length -= 1;
        }

        return totalSpeed;
    }

}
