package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class LevenshteinDistance {

    // https://en.wikipedia.org/wiki/Levenshtein_distance

    public static int levenshteinDistance(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        Integer[][] cache = new Integer[length1 + 1][length2 + 1];
        return levenshteinDistance(str1, length1 - 1, str2, length2 - 1, cache);
    }

    private static int levenshteinDistance(String one, int index1, String two,
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
