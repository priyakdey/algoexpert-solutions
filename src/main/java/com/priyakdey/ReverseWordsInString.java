package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ReverseWordsInString {

    // Start iterating from back and capture words into buffer.

    public String reverseWordsInString(String string) {
        int length = string.length();
        int cursor = length - 1;

        StringBuilder sb = new StringBuilder();
        while (cursor >= 0) {
            char c = string.charAt(cursor);
            if (c == ' ') {
                sb.append(c);
                cursor--;
            } else {
                int end = cursor;
                while (cursor >= 0 && string.charAt(cursor) != ' ') {
                    cursor--;
                }
                sb.append(string, cursor + 1, end + 1);
            }
        }

        return sb.toString();
    }

}
