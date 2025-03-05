package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class MinNumberOfCoinChange {

    // Use dynamic programming

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        Integer[][] cache = new Integer[n + 1][denoms.length + 1];
        int ways = minNumberOfCoinsForChange(n, denoms, 0, cache);
        return Math.max(ways, -1);
    }

    private static int minNumberOfCoinsForChange(int n, int[] denoms,
                                                 int index, Integer[][] cache) {
        if (n == 0) return 0;
        if (index == denoms.length || n < 0) return -1;

        if (cache[n][index] != null) {
            return cache[n][index];
        }

        int minWays = Integer.MAX_VALUE;
        boolean returnNeg = true;
        for (int i = index; i < denoms.length; i++) {
            int coins = minNumberOfCoinsForChange(n - denoms[i], denoms, i,
                    cache);
            if (coins != -1) {
                returnNeg = false;
                minWays = Math.min(minWays, 1 + coins);
            }
        }

        minWays = !returnNeg ? minWays : -1;
        cache[n][index] = minWays;
        return minWays;
    }

}
