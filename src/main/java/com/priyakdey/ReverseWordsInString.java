package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class ReverseWordsInString {

    public String reverseWordsInString(String string) {
        List<String> sentence = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();

        for (char ch : string.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                if (!buffer.isEmpty()) {
                    sentence.addFirst(buffer.toString());
                    buffer.setLength(0);
                }
                sentence.addFirst(Character.toString(ch));
            } else {
                buffer.append(ch);
            }
        }

        if (!buffer.isEmpty()) {
            sentence.addFirst(buffer.toString());
        }

        return String.join("", sentence);

    }

}
