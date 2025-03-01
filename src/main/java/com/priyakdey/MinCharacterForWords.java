package com.priyakdey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class MinCharacterForWords {

    // Create an overall freq map. Iterate over all words and merge the
    // character count into the overall freq map.

    public char[] minimumCharactersForWords(String[] words) {
        if (words.length == 0) {
            return new char[]{};
        }

        Map<Character, Integer> freqMap = new HashMap<>();
        Map<Character, Integer> temp = new HashMap<>();

        for (char ch : words[0].toCharArray()) {
            freqMap.compute(ch, (k, v) -> v == null ? 1 : v + 1);
        }

        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            for (char ch : word.toCharArray()) {
                temp.compute(ch, (k, v) -> v == null ? 1 : v + 1);
            }

            mergeMaps(freqMap, temp);
            temp.clear();
        }

        // TODO: This is pretty lame. Come up with a better solution
        List<Character> tempBuffer = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            char ch = entry.getKey();
            int freq = entry.getValue();
            for (int i = 1; i <= freq; i++) {
                tempBuffer.add(ch);
            }
        }

        char[] chars = new char[tempBuffer.size()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = tempBuffer.get(i);
        }
        return chars;
    }

    /**
     * Merge data into map1. If keys existing, value is set to the max of
     * values from both maps. If key non-existing, the key is added to map 1.
     *
     * @param destination destination map into which keys are merged
     * @param source      source map from which keys are merged
     */
    private void mergeMaps(Map<Character, Integer> destination,
                           Map<Character, Integer> source) {
        for (Map.Entry<Character, Integer> entry : source.entrySet()) {
            Character key = entry.getKey();
            int value = entry.getValue();

            destination.compute(key, (k, v) ->
                    v == null ? value : Math.max(value, destination.get(key)));

        }
    }
}
