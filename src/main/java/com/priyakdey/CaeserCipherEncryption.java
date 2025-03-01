package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class CaeserCipherEncryption {

    // Get the code point and offset by 97 to bring it in the range of
    // 0-26 and then add the key. Since this can overflow, mod with 26.
    // Add 'a' back to bring it back to ascii range.
    // Use a buffer to accumulate the result.

    public static String caesarCypherEncryptor(String str, int key) {
        StringBuilder buf = new StringBuilder();

        for (char ch : str.toCharArray()) {
            int codePoint = ((ch - 'a' + key) % 26) + 'a';
            buf.appendCodePoint(codePoint);
        }

        return buf.toString();
    }

}
