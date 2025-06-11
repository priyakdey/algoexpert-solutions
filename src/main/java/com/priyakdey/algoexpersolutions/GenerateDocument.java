package com.priyakdey.algoexpersolutions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class GenerateDocument {

    // Count available character frequencies from characters, then consume them for document —
    // fail if any count goes negative or missing.

    public boolean generateDocument(String characters, String document) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : characters.toCharArray()) {
            freqMap.compute(ch, (_, v) -> v == null ? 1 : v + 1);
        }

        for (char ch : document.toCharArray()) {
            if (!freqMap.containsKey(ch)) {
                return false;
            }

            int freq = freqMap.get(ch);
            if (freq - 1 == -1) return false;
            freqMap.put(ch, freq - 1);
        }

        return true;
    }

}
