package com.priyakdey.algoexpersolutions;

/**
 * @author Priyak Dey
 */
public class ReverseWordsInAString {


    // Reverse the words by scanning from the end, appending each word and its trailing spaces i
    // n-place using StringBuilder. Track each word’s end and move backward to its start,
    // then add it to the result. Preserve spacing exactly as in input — useful for
    // formatting-sensitive cases.

    public String reverseWordsInString(String string) {
        StringBuilder sb = new StringBuilder();
        int cursor = string.length() - 1;

        while (cursor >= 0) {
            int end = cursor + 1;
            while (cursor >= 0 && string.charAt(cursor) != ' ') {
                cursor--;
            }
            sb.append(string, cursor + 1, end);

            while (cursor >= 0 && string.charAt(cursor) == ' ') {
                sb.append(string.charAt(cursor));
                cursor--;
            }
        }

        return sb.toString();
    }

}
