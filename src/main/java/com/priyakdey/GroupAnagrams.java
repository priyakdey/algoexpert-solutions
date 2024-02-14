package com.priyakdey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class GroupAnagrams {

    private static final int[] PRIMES =
        new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73,
            79, 83, 89, 97, 101};
    private static final int MOD = 1_000_000_007;

    public static List<List<String>> groupAnagrams(List<String> words) {
        Map<Integer, List<String>> anagramMap = new HashMap<>();

        for (String word : words) {
            int hash = hash(word);
            anagramMap.compute(hash, (k, v) -> {
                if (v == null) v = new ArrayList<>();
                v.add(word);
                return v;
            });
        }

        return anagramMap.values().stream().toList();
    }

    private static int hash(String word) {
        long hash = 5381;
        for (char ch : word.toCharArray()) {
            int index = ch - 97;
            hash *= PRIMES[index];
            hash = hash % MOD;
        }

        return (int) hash;
    }

}
