package com.priyakdey.algoexpersolutions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class LongestSubstringWithoutDuplication {

    // Use a sliding window and a hashmap to track last seen indices — reset window start on
    // duplicates to ensure unique characters.
    //
    // Whenever a duplicate is found inside the current window, shift the window start to
    // just after its last occurrence.
    // Track max substring length and return the [left, right) slice of the original string.

    public static String longestSubstringWithoutDuplication(String str) {
        int maxLength = 1;
        int left = 0, right = 1;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch) && map.get(ch) >= start) {
                int length = i - start;
                if (length > maxLength) {
                    maxLength = length;
                    left = start;
                    right = i;
                }
                start = map.get(ch) + 1;
            }

            map.put(ch, i);
        }

        int length = str.length() - start;
        if (length > maxLength) {
            left = start;
            right = str.length();
        }

        return str.substring(left, right);
    }

}
