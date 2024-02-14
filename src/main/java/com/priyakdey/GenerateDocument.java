package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class GenerateDocument {

    public boolean generateDocument(String characters, String document) {
        if (document.isEmpty()) return true;

        char[] charFreq = new char[256];
        for (char ch : characters.toCharArray()) {
            charFreq[(int) ch]++;
        }

        for (char ch : document.toCharArray()) {
            if (charFreq[ch] == 0) return false;
            charFreq[(int) ch]--;
        }

        return true;
    }

}
