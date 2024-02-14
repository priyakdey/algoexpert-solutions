package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class CaeserCypherEncryptor {

    public static String caesarCypherEncryptor(String str, int key) {
        StringBuilder buffer = new StringBuilder();
        str.chars()
            .map(c -> c + (key % 26))
            .map(c -> c <= 122 ? c : c - 26)
            .forEach(buffer::appendCodePoint);

        return buffer.toString();
    }

}
