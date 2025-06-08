package com.priyakdey.algoexpersolutions;

/**
 * @author Priyak Dey
 */
public class LongestPalindromicString {

    // Expand around each character (odd & even centers) to find the longest palindromic
    // substring in O(n²) time. For each index, grow two palindromes: one with a single center (i),
    // one with double center (i and i+1).
    // Track the max length and update left/right bounds for final substring extraction.

    public static String longestPalindromicSubstring(String str) {
        int strLength = str.length();
        int left = 0, right = 1;
        int maxSubstrLength = 1;

        int j, k;

        for (int i = 0; i < strLength; i++) {
            j = i - 1;
            k = i + 1;
            while (j >= 0 && k < strLength && str.charAt(j) == str.charAt(k)) {
                j--;
                k++;
            }

            int substrLength = k - (j + 1);
            if (substrLength > maxSubstrLength) {
                left = j + 1;
                right = k;
                maxSubstrLength = substrLength;
            }

            if (i < strLength - 1 && str.charAt(i) == str.charAt(i + 1)) {
                j = i - 1;
                k = i + 2;
                while (j >= 0 && k < strLength && str.charAt(j) == str.charAt(k)) {
                    j--;
                    k++;
                }

                substrLength = k - (j + 1);
                if (substrLength > maxSubstrLength) {
                    left = j + 1;
                    right = k;
                    maxSubstrLength = substrLength;
                }
            }
        }

        return str.substring(left, right);
    }

}
