package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class LongestPalindromicSubstring {

    // From each index, try and stretch out on both directions to generate
    // palindrome. Ensure to try both odd length and even length palindromes.

    public static String longestPalindromicSubstring(String str) {
        assert str != null;
        int length = str.length();
        if (length < 2) {
            return str;
        }

        int leftBound = 0, rightBound = 1;
        int maxLength = 1;

        for (int i = 0; i < length - 1; i++) {
            // odd length palindromes
            {
                int left = i - 1;
                int right = i + 1;
                while (left >= 0 && right < length && str.charAt(left) == str.charAt(right)) {
                    left--;
                    right++;
                }
                int substringLength = (right - 1) - (left + 1) + 1;
                if (substringLength > maxLength) {
                    maxLength = substringLength;
                    leftBound = left + 1;
                    rightBound = right;
                }
            }

            // even length palindromes
            if (i < length - 1 && str.charAt(i) == str.charAt(i + 1)) {
                int left = i - 1;
                int right = i + 2;
                while (left >= 0 && right < length && str.charAt(left) == str.charAt(right)) {
                    left--;
                    right++;
                }
                int substringLength = (right - 1) - (left + 1) + 1;
                if (substringLength > maxLength) {
                    maxLength = substringLength;
                    leftBound = left + 1;
                    rightBound = right;
                }
            }
        }

        return str.substring(leftBound, rightBound);
    }

}
