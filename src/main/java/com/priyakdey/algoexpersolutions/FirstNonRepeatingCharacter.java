package com.priyakdey.algoexpersolutions;

/**
 * @author Priyak Dey
 */
public class FirstNonRepeatingCharacter {

    // Count character frequencies, then scan again to find the first character with count 1.

    public int firstNonRepeatingCharacter(String string) {
        int[] count = new int[26];

        for (char ch : string.toCharArray()) {
            count[ch - 97]++;
        }

        int index = -1;

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (count[ch - 97] == 1) {
                index = i;
                break;
            }
        }

        return index;
    }

}
