package com.priyakdey;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class CommonCharacters {

    // Use a hashmap to count freq for all distinct characters
    // of a word. If freq count == word count, it is a common
    // character

    public String[] commonCharacters(String[] strings) {
        Set<Character> common = new HashSet<>();
        for (char ch : strings[0].toCharArray()) {
            common.add(ch);
        }

        Set<Character> distinct = new HashSet<>();
        for (int i = 1; i < strings.length; i++) {
            for (char ch : strings[i].toCharArray()) {
                distinct.add(ch);
            }

            common.retainAll(distinct);
            distinct.clear();
        }

        String[] result = new String[common.size()];
        int i = 0;
        for (Character ch : common) {
            result[i++] = ch.toString();
        }

        return result;
    }

}
