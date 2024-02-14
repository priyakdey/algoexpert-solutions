package com.priyakdey;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class NonConstructibleChange {

    public int nonConstructibleChange(int[] coins) {
        Objects.requireNonNull(coins);
        int length = coins.length;
        if (length == 0) return 1;
        if (length == 1) return coins[0] == 1 ? 2 : 1;

        Arrays.sort(coins);

        if (coins[0] != 1) return 1;

        int canMake = 1;
        for (int i = 1; i < length; i++) {
            if (canMake + 1 < coins[i]) break;
            canMake += coins[i];
        }

        return canMake + 1;
    }

}
