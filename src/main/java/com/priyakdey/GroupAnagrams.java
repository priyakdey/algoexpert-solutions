package com.priyakdey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class GroupAnagrams {

    // Find hash of the words and group by hashes.
    // Hash can be prime multiplicative

    private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
            31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

    private static final int LARGE_PRIME = 1_000_000_007;
    private static final int SEED = 5381;

    public static List<List<String>> groupAnagrams(List<String> words) {
        Map<Integer, List<String>> anagrams = new HashMap<>();
        for (String word : words) {
            int hash = getHash(word);
            if (!anagrams.containsKey(hash)) {
                anagrams.put(hash, new ArrayList<>());
            }
            anagrams.get(hash).add(word);
        }

        List<List<String>> groups = new ArrayList<>(anagrams.size());
        groups.addAll(anagrams.values());
        return groups;
    }

    private static int getHash(String word) {
        long hash = SEED;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            hash = (hash * PRIMES[index]) % LARGE_PRIME;
        }

        return (int) hash;
    }

}
