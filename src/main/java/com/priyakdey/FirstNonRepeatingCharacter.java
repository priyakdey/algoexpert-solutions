package com.priyakdey;

import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class FirstNonRepeatingCharacter {

    public int firstNonRepeatingCharacter(String string) {
        Objects.requireNonNull(string);
        int length = string.length();
        if (length <= 1) return length;

        int[] charFreq = new int[256];
        for(char ch : string.toCharArray()) {
            charFreq[(int) ch]++;
        }

        for (int i = 0; i < length; i++) {
            char ch = string.charAt(i);
            if (charFreq[(int) ch] == 1) return i;
        }

        return -1;
    }

}
