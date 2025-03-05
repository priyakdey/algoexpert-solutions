package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class NumberOfWaysToMakeChange {

    // Use dynamic programming to determine the number of ways.

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int length = denoms.length;
        Integer[][] cache = new Integer[n + 1][length + 1];
        return numberOfWaysToMakeChange(n, denoms, 0, cache);
    }

    public static int numberOfWaysToMakeChange(int n, int[] denoms, int index,
                                               Integer[][] cache) {
        if (n == 0) return 1;
        if (index == denoms.length || n < 0) return 0;

        if (cache[n][index] != null) {
            return cache[n][index];
        }

        int totalWays = numberOfWaysToMakeChange(n, denoms, index + 1, cache);
        totalWays += numberOfWaysToMakeChange(n - denoms[index], denoms,
                index, cache);

        cache[n][index] = totalWays;
        return totalWays;
    }
}
