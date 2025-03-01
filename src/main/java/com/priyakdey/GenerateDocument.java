package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class GenerateDocument {

    // Use a hashmap to get freq and then compare
    // and see that in document all char freq are less than
    // in the generator set.

    public boolean generateDocument(String characters, String document) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : characters.toCharArray()) {
            freqMap.compute(ch, (k, v) -> v == null ? 1 : v + 1);
        }

        for (char ch : document.toCharArray()) {
            if (!freqMap.containsKey(ch) || freqMap.get(ch) == 0) {
                return false;
            }

            freqMap.put(ch, freqMap.get(ch) - 1);
        }

        return true;
    }

}
