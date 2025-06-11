package com.priyakdey.algoexpersolutions;

/**
 * @author Priyak Dey
 */
public class PalindromeCheck {

    // Use two pointers from both ends — check if chars match while shrinking toward center;
    // early exit on mismatch.

    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;

        while (left < right && str.charAt(left) == str.charAt(right)) {
            left++;
            right--;
        }

        return left >= right;
    }

}
