package com.priyakdey;

import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class OneEdit {

    // Find the levenshtein distance

    public boolean oneEdit(String stringOne, String stringTwo) {
        if (Objects.equals(stringOne, stringTwo)) {
            return true;
        }

        int length1 = stringOne.length();
        int length2 = stringTwo.length();
        if (Math.abs(length1 - length2) > 1) {
            return false;
        }

        int[][] cache = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {
            for (int j = 0; j <= length2; j++) {
                if (i == 0) {
                    cache[i][j] = j;
                } else if (j == 0) {
                    cache[i][j] = i;
                } else if (stringOne.charAt(i - 1) == stringTwo.charAt(j - 1)) {
                    cache[i][j] = cache[i - 1][j - 1];
                } else {
                    cache[i][j] = 1 + min(cache[i - 1][j], cache[i][j - 1],
                            cache[i - 1][j - 1]);
                }
            }
        }

        return cache[length1][length2] == 1;

        // Integer[][] cache = new Integer[length1 + 1][length2 + 1];
        // return levenshteinDistance(stringOne, length1 - 1, stringTwo,
        //         length2 - 1, cache) == 1;
    }

    private int levenshteinDistance(String one, int index1, String two,
                                    int index2, Integer[][] cache) {
        if (index1 == -1) {
            return index2 + 1;
        }
        if (index2 == -1) {
            return index1 + 1;
        }

        if (cache[index1][index2] != null) {
            return cache[index1][index2];
        }

        if (one.charAt(index1) == two.charAt(index2)) {
            return levenshteinDistance(one, index1 - 1, two, index2 - 1, cache);
        }


        int dist = 1 + min(
                levenshteinDistance(one, index1 - 1, two, index2, cache),
                levenshteinDistance(one, index1, two, index2 - 1, cache),
                levenshteinDistance(one, index1 - 1, two, index2 - 1, cache)
        );

        cache[index1][index2] = dist;
        return dist;
    }

    private static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

}
