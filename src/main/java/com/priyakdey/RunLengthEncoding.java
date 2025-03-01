package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class RunLengthEncoding {

    // iterate a cursor while character is same in the range
    // and length < 10. Keep accumulating such ranges till the end.

    public String runLengthEncoding(String string) {
        StringBuilder buffer = new StringBuilder();

        int cursor = 0;
        while (cursor < string.length()) {
            char ch = string.charAt(cursor);
            int start = cursor;
            while (cursor < string.length() && ch == string.charAt(cursor)
                    && cursor - start + 1 < 10) {
                cursor++;
            }

            buffer.append(cursor - start);
            buffer.append(ch);
        }

        return buffer.toString();
    }

}
