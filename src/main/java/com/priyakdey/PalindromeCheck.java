package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class PalindromeCheck {

    // Two pointers in extreme ends, move them towards one another
    // if characters at each pointer is same.
    // If left >= right input is palindrome.

    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right && str.charAt(left) == str.charAt(right)) {
            left++;
            right--;
        }

        return left >= right;
    }

}
