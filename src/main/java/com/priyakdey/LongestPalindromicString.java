package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class LongestPalindromicString {

    public static String longestPalindromicSubstring(String str) {
        if (str.length() <= 1) return str;

        int maxLength = 1;
        // both left and right are inclusive.
        int left = 0, right = 1;

        for (int i = 0; i < str.length(); i++) {
            // check for odd length palindromes
            int l = i - 1, r = i + 1;
            while (l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
                l--;
                r++;
            }

            int length = (r - l) + 1 - 2;
            if (length > maxLength) {
                maxLength = length;
                left = l + 1;
                right = r - 1;
            }

            // check for even length palindromes
            if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                l = i - 1;
                r = i + 2;
                while (l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
                    l--;
                    r++;
                }

                length = (r - l) + 1 - 2;
                if (length > maxLength) {
                    maxLength = length;
                    left = l + 1;
                    right = r - 1;
                }
            }

        }

        return str.substring(left, right + 1);
    }


}
