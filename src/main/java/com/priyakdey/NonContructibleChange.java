package com.priyakdey;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class NonContructibleChange {

    // For a sorted array, at any given index, the minimum
    // we cannot make is currSum + 1, if currSum + 1 < current_value

    public int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int currSum = 0;
        for(int coin : coins) {
            if (currSum + 1 < coin) {
                break;
            }
            currSum += coin;
        }

        return currSum + 1;
    }

}
