package com.priyakdey.algoexpersolutions;

/**
 * @author Priyak Dey
 */
public class CaeserCipherEncryptor {

    // Shift each lowercase character by key positions with wraparound using modulo 26 —
    // classic Caesar Cipher logic.

    public static String caesarCypherEncryptor(String str, int key) {
        StringBuilder encrypted = new StringBuilder();

        for (char ch : str.toCharArray()) {
            int codePoint = (((ch - 97) + key) % 26) + 97;
            encrypted.appendCodePoint(codePoint);
        }

        return encrypted.toString();
    }

}
