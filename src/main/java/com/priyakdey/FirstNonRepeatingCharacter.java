package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class FirstNonRepeatingCharacter {

    // Use a hashmap to store freq of each character. Iterate over
    // string again to find out first character with freq = 1.
    // Since input is all english-lowercase, we used a vector instead
    // of hashmap

    public int firstNonRepeatingCharacter(String string) {
        int[] freq = new int[26];

        for (char ch : string.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (freq[ch - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

}
